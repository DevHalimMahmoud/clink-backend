package com.abdelhalim.egypt.clinics.api.clinic.entity;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import jakarta.persistence.*;

@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(nullable = false)
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
