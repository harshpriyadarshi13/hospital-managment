package com.pree.hospitalManagement.entity;

import com.pree.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Data
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthDate", columnNames = {"name","dob"})
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private LocalDate dob;
    private String email;

    @ToString.Exclude
    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")//owning side
    private Insurence insurence;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE} , orphanRemoval = true ,fetch = FetchType.EAGER)
    private List<Appoinment> appoinments = new ArrayList<>();



}
