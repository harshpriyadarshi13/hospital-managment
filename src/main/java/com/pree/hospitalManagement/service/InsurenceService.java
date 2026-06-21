package com.pree.hospitalManagement.service;

import com.pree.hospitalManagement.entity.Insurence;
import com.pree.hospitalManagement.entity.Patient;
import com.pree.hospitalManagement.repository.InsurenceRepository;
import com.pree.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsurenceService {

    private final InsurenceRepository insurenceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsurenceToPatient(Insurence insurence, long patient_id){

        Patient patient = patientRepository.findById(patient_id).orElseThrow(()-> new EntityNotFoundException("Patient not fount with patient id : "+patient_id));

        patient.setInsurence(insurence);

        insurence.setPatient(patient); // bidirectional consistancy mentainance

//        insurenceRepository.save(insurence); it will saved due to cascade

        return patient;

    }

    @Transactional
    public Patient disAssociatePatientFromInsurence(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurence(null);

        return patient;

    }
}
