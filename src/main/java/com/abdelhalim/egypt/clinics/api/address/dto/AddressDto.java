package com.abdelhalim.egypt.clinics.api.address.dto;

import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;

public class AddressDto {

    private String name;
    private Governorate governorate;

    public AddressDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Governorate getGovernorate() {
        return governorate;
    }

    public void setGovernorate(Governorate governorate) {
        this.governorate = governorate;
    }
}