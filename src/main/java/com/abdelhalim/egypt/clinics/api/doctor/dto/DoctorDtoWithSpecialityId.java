package com.abdelhalim.egypt.clinics.api.doctor.dto;

public class DoctorDtoWithSpecialityId {

    private String name;
    private String nameAr;
    private String image;
    private Long[] specialityIds;

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

    public Long[] getSpecialityIds() {
        return specialityIds;
    }

    public void setSpecialityIds(Long[] specialityI) {
        this.specialityIds = specialityI;
    }
}