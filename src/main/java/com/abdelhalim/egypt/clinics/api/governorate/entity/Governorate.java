package com.abdelhalim.egypt.clinics.api.governorate.entity;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Governorate {
    @OneToMany
    @JoinColumn(name = "address_id")
    private final Set<Address> address_list = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String name_ar;

    public Governorate() {

    }

    public Governorate(Long id, String name, String name_ar) {
        this.id = id;
        this.name = name;
        this.name_ar = name_ar;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
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
