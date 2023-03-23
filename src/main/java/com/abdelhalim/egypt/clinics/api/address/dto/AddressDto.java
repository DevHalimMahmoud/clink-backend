package com.abdelhalim.egypt.clinics.api.address.dto;

public class AddressDto {

    private String name;
    private Long name_ar;

    public AddressDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getName_ar() {
        return name_ar;
    }

    public void setName_ar(Long name_ar) {
        this.name_ar = name_ar;
    }

}