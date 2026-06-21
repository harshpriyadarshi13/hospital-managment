package com.pree.hospitalManagement.repository;

import com.pree.hospitalManagement.dto.BloodGroupCountResponceEntity;
import com.pree.hospitalManagement.entity.Patient;
import com.pree.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
    List<Patient>findByBloodGroup(BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p where p.dob > :birthDate ")
    List<Patient>findPatientAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("select new com.pree.hospitalManagement.dto.BloodGroupCountResponceEntity(p.bloodGroup,Count(p)) from Patient p where p.bloodGroup is not NULL group by p.bloodGroup")
//    List<Object[]>findCountEachBloodGroup();
    List<BloodGroupCountResponceEntity>findCountEachBloodGroup();

    @Query(value = "select * from patient",nativeQuery = true)
//    List<Patient>findAllPatient();
    Page<Patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appoinments a LEFT JOIN a.doctor")
    List<Patient> findAllPatientWithAppoinment();
}
