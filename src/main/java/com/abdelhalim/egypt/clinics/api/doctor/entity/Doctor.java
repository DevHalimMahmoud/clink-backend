package com.abdelhalim.egypt.clinics.api.doctor.entity;

import com.abdelhalim.egypt.clinics.api.specialty.entity.Specialty;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity
@DynamicUpdate
public class Doctor {
    @Id
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "name_ar")
    private String nameAr;
    @Column(nullable = false)
    private String image;
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Specialty> specialtyList;


    public Doctor() {

    }

    public Doctor(Long id, String name, String nameAr, String image, List<Specialty> specialtyList) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
        this.image = image;
        this.specialtyList = specialtyList;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Specialty> getSpecialtyList() {
        return specialtyList;
    }

    public void setSpecialtyList(List<Specialty> specialtyList) {
        this.specialtyList = specialtyList;
    }
}
