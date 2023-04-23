package com.abdelhalim.egypt.clinics.entities;

import com.abdelhalim.egypt.clinics.entities.Specialty;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity
@DynamicUpdate
public class User {
    @Id
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "name_ar")
    private String nameAr;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    @Column(nullable = false)
    private Boolean isVerified;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    // USER, DOCTOR, ADMIN, LABORATORY, HOSPITAL
    @Column(nullable = false)
    private String role = "USER";
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Specialty> specialtyList;

    public User() {

    }

    public User(Long id, String name, String nameAr, String image, List<Specialty> specialtyList) {
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