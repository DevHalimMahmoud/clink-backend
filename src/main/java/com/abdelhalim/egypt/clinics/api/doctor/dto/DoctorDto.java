package com.abdelhalim.egypt.clinics.api.doctor.dto;

public class DoctorDto {

    private String name;
    private String nameAr;
    private String image;

    public DoctorDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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