package com.abdelhalim.egypt.clinics.doctor.entity;

import com.abdelhalim.egypt.clinics.clinic.entity.Clinic;
import com.abdelhalim.egypt.clinics.speciality.entity.Specialty;
import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    // getters and setters
}
