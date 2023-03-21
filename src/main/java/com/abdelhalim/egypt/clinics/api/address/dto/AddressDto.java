package com.abdelhalim.egypt.clinics.api.address.dto;

public class AddressDto {

    private String name;
    private Long governorate_id;

    public AddressDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGovernorate() {
        return governorate_id;
    }

    public void setGovernorate(Long governorate_id) {
        this.governorate_id = governorate_id;
    }
}