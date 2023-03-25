package com.abdelhalim.egypt.clinics.api.clinic.dto;

import java.util.List;

public class ClinicDtoWithIds {

    private String name;

    private String phoneNumber;
    private String nameAr;
    private String image;
    private List<Long> addressIds;
    private List<Long> doctorIds;

    public ClinicDtoWithIds() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getNameAr() {
        return nameAr;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public List<Long> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(List<Long> addressIds) {
        this.addressIds = addressIds;
    }

    public List<Long> getDoctorIds() {
        return doctorIds;
    }

    public void setDoctorIds(List<Long> doctorIds) {
        this.doctorIds = doctorIds;
    }

}