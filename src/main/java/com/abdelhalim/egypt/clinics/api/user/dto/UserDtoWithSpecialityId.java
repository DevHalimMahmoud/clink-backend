package com.abdelhalim.egypt.clinics.api.user.dto;

import java.util.List;

public class UserDtoWithSpecialityId {

    private String name;
    private String nameAr;
    private String image;


    private List<Long> specialityIds;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public List<Long> getSpecialityIds() {
        return specialityIds;
    }

    public void setSpecialityIds(List<Long> specialityIds) {
        this.specialityIds = specialityIds;
    }
}