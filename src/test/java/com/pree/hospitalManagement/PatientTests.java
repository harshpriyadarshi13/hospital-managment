package com.pree.hospitalManagement;

import com.pree.hospitalManagement.dto.BloodGroupCountResponceEntity;
import com.pree.hospitalManagement.entity.Patient;
import com.pree.hospitalManagement.entity.type.BloodGroupType;
import com.pree.hospitalManagement.repository.PatientRepository;
import com.pree.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
//        System.out.println(patientList);
    }

    @Test
    public void testPatientRepository2(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppoinment();
        System.out.println(patientList);
    }

    @Test
    public  void testTrainsational(){
//        Patient patient = patientService.getPatientById(1L);
//        Patient patient = patientRepository.findByName("polo");
//       List<Patient> patient = patientRepository.findByBloodGroup(BloodGroupType.B_POSITIVE);
//       List<Patient> patient = patientRepository.findPatientAfterDate(LocalDate.of(2001,9,27));
//       List<Object[]> bloodGroupCount = patientRepository.findCountEachBloodGroup();
//
//        for(Object[] objects : bloodGroupCount){
//            System.out.println(objects[0] + " " + objects[1]);
//        }
//
//        List<Patient> patients = patientRepository.findAllPatient();
//
//        System.out.println(patients);

//        int updatedRow = patientRepository.updateNameWithId("Arav Kishor",3L);
//
//        System.out.println(updatedRow);

//        List<Patient> patients = patientRepository.findAllPatient();
//
//        System.out.println(patients);

//       List<BloodGroupCountResponceEntity> bloodGroupCount = patientRepository.findCountEachBloodGroup();
//
//                for(BloodGroupCountResponceEntity bloodGroupCountResponce : bloodGroupCount){
//            System.out.println(bloodGroupCountResponce);
//        }

        Page<Patient> patients = patientRepository.findAllPatient(PageRequest.of(0,5));
        for(Patient p : patients){
            System.out.println(p);
        }

    }
}
