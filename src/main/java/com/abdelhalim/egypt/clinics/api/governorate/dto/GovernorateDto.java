package com.abdelhalim.egypt.clinics.api.governorate.dto;

public class GovernorateDto {
    private int id;
    private String name;

    public GovernorateDto() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}