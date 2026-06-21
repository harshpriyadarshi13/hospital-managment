package com.pree.hospitalManagement.controller;

import com.pree.hospitalManagement.entity.Patient;
import com.pree.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientContoller {

    private final PatientService patientService;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
       return patientService.createPatient(patient);
    }

    @GetMapping("/{id}")

    public Patient findPatientById(@PathVariable("id") Long id){
        return patientService.getPatientById(id);
    }


}
