package com.pree.hospitalManagement.service;

import com.pree.hospitalManagement.entity.Appoinment;
import com.pree.hospitalManagement.entity.Doctor;
import com.pree.hospitalManagement.entity.Patient;
import com.pree.hospitalManagement.repository.AppoinmentRepository;
import com.pree.hospitalManagement.repository.DoctorRepository;
import com.pree.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppoinmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppoinmentRepository appoinmentRepository;

    @Transactional
    public Appoinment createAppoinment(Appoinment appoinment, Long patientId, Long docterId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor =  doctorRepository.findById(docterId).orElseThrow();

        appoinment.setDoctor(doctor);
        appoinment.setPatient(patient);

        patient.getAppoinments().add(appoinment); // to maintain consistancy
        return appoinmentRepository.save(appoinment);

    }

    @Transactional
    public Appoinment reAssignAppoinmentToAnotherDoctor(Long appoinmentId, Long doctorId){
        Appoinment appoinment = appoinmentRepository.findById(appoinmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appoinment.setDoctor(doctor); // this will automatically call the update because it is dirty

        doctor.getAppoinmentList().add(appoinment); //just for bidirectional consistency

        return appoinment;
    }
}
