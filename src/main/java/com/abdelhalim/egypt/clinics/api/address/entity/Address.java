package com.abdelhalim.egypt.clinics.api.address.entity;

import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorateList;

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

    public Governorate getGovernorateList() {
        return governorateList;
    }

    public void setGovernorateList(Governorate governorateList) {
        this.governorateList = governorateList;
    }
}
