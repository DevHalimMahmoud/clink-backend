package com.abdelhalim.egypt.clinics.api.address.entity;

import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String name_ar;
    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;
//    @ManyToOne
//    @JoinColumn(name = "clinic_id")
//    private Clinic clinic;

    public Address() {

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

    public Governorate getGovernorate() {
        return governorate;
    }

    public void setGovernorate(Governorate governorate) {
        this.governorate = governorate;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

//    public Clinic getClinic() {
//        return clinic;
//    }
//
//    public void setClinic(Clinic clinic) {
//        this.clinic = clinic;
//    }
}
