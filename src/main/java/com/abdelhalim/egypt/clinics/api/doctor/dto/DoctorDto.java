package com.abdelhalim.egypt.clinics.api.doctor.dto;

import com.abdelhalim.egypt.clinics.entities.specialty.Specialty;

import java.util.List;

public class DoctorDto {

    private String name;
    private String nameAr;
    private String image;
    private List<Specialty> specialtyList;


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

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
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

    public List<Specialty> getSpecialtyList() {
        return specialtyList;
    }

    public void setSpecialtyList(List<Specialty> specialtyList) {
        this.specialtyList = specialtyList;
    }


}