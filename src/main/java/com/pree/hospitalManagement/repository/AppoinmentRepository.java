package com.pree.hospitalManagement.repository;

import com.pree.hospitalManagement.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {
}