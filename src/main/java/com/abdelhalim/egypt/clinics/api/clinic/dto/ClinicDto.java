package com.abdelhalim.egypt.clinics.api.clinic.dto;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;

public class ClinicDto {

    private String name;
    private Address address;
    private String phoneNumber;
    private String specialty_id;
    private String doctor_id;
    private String nameAr;
    private String image;

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

    public String getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(String specialty_id) {
        this.specialty_id = specialty_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setName_ar(String name_ar) {
        this.nameAr = name_ar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}