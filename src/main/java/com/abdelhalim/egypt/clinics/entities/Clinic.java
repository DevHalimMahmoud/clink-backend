package com.abdelhalim.egypt.clinics.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity
@DynamicUpdate
public class Clinic {
    @Id
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "name_ar")
    private String nameAr;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;
    @OneToMany
    @JoinColumn(name = "clinic_id")
    private List<Address> addressList;
    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "clinic_id")
    private List<User> userList;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


    public List<User> getDoctorList() {
        return userList;
    }

    public void setDoctorList(List<User> userList) {
        this.userList = userList;
    }
}