package com.abdelhalim.egypt.clinics.api.speciality.dto;

public class MultiLangSpecialityDto {

    private String name;

    private String name_ar;

    public MultiLangSpecialityDto() {
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
}