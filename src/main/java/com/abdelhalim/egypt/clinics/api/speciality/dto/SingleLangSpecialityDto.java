package com.abdelhalim.egypt.clinics.api.speciality.dto;

public class SingleLangSpecialityDto {


    private String name;

    public SingleLangSpecialityDto() {
    }

    public SingleLangSpecialityDto(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}