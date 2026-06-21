package com.pree.hospitalManagement;

import com.pree.hospitalManagement.entity.Appoinment;
import com.pree.hospitalManagement.entity.Insurence;
import com.pree.hospitalManagement.service.AppoinmentService;
import com.pree.hospitalManagement.service.InsurenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsurenceTest {

    @Autowired
    private InsurenceService insurenceService;

    @Autowired
    private AppoinmentService appoinmentService;

    @Test
    public void testInsurence(){
        Insurence insurence = Insurence.builder()
                .policyNumber("HDFC_2412")
                .provider("HDFC")
                .validUntil(LocalDate.of(2029,2,2))
                .build();

        insurenceService.assignInsurenceToPatient(insurence,1);

    }

    @Test
    public void testDeInsurence(){
        Insurence insurence = Insurence.builder()
                .policyNumber("HDFC_2412")
                .provider("HDFC")
                .validUntil(LocalDate.of(2029,2,2))
                .build();

        var patient = insurenceService.assignInsurenceToPatient(insurence,1);

        System.out.println(patient);

        var newPatient = insurenceService.disAssociatePatientFromInsurence(1L);

        System.out.println(newPatient);

    }

    @Test
    public void testAppoinment(){

        Appoinment appoinment = Appoinment.builder()
                .appoinmentTime(LocalDateTime.of(2026,2,2,8,22))
                .reason("Stomach pain")
                .build();

        appoinmentService.createAppoinment(appoinment,2L,1L);
    }

    @Test
    public void testReAppoinment(){

        Appoinment appoinment = Appoinment.builder()
                .appoinmentTime(LocalDateTime.of(2026,2,2,8,22))
                .reason("Stomach pain")
                .build();

        var UpdatedAppoinmentOld =  appoinmentService.createAppoinment(appoinment,2L,1L);

        System.out.println(UpdatedAppoinmentOld);

        var UpdatedAppoinment = appoinmentService.reAssignAppoinmentToAnotherDoctor(appoinment.getId(),2L);

        System.out.println(UpdatedAppoinment);
    }

}
