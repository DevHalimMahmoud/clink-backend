package com.abdelhalim.egypt.clinics.api.specialty.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity
@DynamicUpdate
public class Specialty {
    @Id
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "name_ar")
    private String nameAr;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    public Specialty() {
    }

    public Specialty(Long id, String name, String name_ar) {
        this.id = id;
        this.name = name;
        this.nameAr = name_ar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
}
