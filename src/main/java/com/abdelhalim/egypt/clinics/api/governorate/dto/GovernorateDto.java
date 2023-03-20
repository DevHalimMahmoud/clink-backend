package com.abdelhalim.egypt.clinics.api.governorate.dto;

public class GovernorateDto {

    private String name;
    private String name_ar;

    public GovernorateDto() {
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}