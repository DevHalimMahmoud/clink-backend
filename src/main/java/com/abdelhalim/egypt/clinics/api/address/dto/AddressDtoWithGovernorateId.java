package com.abdelhalim.egypt.clinics.api.address.dto;

public class AddressDtoWithGovernorateId {

    private String name;
    private String nameAr;

    private Long governorateId;

    public AddressDtoWithGovernorateId() {
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

    public Long getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(Long governorateId) {
        this.governorateId = governorateId;
    }
}