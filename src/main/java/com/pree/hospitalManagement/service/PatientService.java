package com.pree.hospitalManagement.service;

import com.pree.hospitalManagement.entity.Patient;
import com.pree.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional

    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        return p1;
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient){
        Patient temp = getPatientById(patient.getId());
        if(temp != null){
            temp = patient;
            patientRepository.save(temp);
        }
        return temp;
    }

    public Patient delete(Long id){
        Patient patient = getPatientById(id);
        if(patient != null){
            patientRepository.delete(patient);
        }
        return patient;
    }

}
