package com.abdelhalim.egypt.clinics.api.governorate.dto;

public class GovernorateDto {

    private String name;
    private String nameAr;

    public GovernorateDto() {
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setName_ar(String name_ar) {
        this.nameAr = name_ar;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}