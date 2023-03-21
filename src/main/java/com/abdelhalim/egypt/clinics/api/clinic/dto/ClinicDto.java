package com.abdelhalim.egypt.clinics.api.clinic.dto;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;

public class ClinicDto {

    private String name;

    private Address address;
    private String phoneNumber;

    private Specialty specialty;

    private Doctor doctor;

    public ClinicDto() {
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