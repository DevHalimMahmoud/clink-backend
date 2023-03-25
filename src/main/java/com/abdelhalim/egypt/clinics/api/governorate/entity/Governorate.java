package com.abdelhalim.egypt.clinics.api.governorate.entity;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicUpdate
public class Governorate {
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "governorate_id")
    private List<Address> addressSet;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "name_ar")
    private String nameAr;

    public Governorate() {

    }

    public Governorate(Long id, String name, String nameAr) {
        this.id = id;
        this.name = name;
        this.nameAr = nameAr;
    }

    public List<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(List<Address> addressSet) {
        this.addressSet = addressSet;
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
}
