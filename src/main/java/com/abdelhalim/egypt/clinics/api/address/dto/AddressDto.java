package com.abdelhalim.egypt.clinics.api.address.dto;

import com.abdelhalim.egypt.clinics.entities.Governorate;

public class AddressDto {

    private String name;
    private String nameAr;
    private Governorate governorate;

    public AddressDto() {
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

    public Governorate getGovernorate() {
        return governorate;
    }

    public void setGovernorate(Governorate governorate) {
        this.governorate = governorate;
    }
}