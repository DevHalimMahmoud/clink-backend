package com.abdelhalim.egypt.clinics.api.doctor.dto;

public class DoctorDto {

    private String name;
    private String name_ar;
    private String image;

    public DoctorDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}