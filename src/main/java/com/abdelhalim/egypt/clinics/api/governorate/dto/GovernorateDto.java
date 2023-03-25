package com.abdelhalim.egypt.clinics.api.governorate.dto;

public class GovernorateDto {

    private String name;
    private String nameAr;

    public GovernorateDto() {
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameAr() {
        return nameAr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}