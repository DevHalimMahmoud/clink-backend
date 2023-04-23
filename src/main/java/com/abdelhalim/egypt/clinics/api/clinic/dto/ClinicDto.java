package com.abdelhalim.egypt.clinics.api.clinic.dto;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.user.entity.User;

import java.util.List;

public class ClinicDto {

    private String name;
    private List<Address> addressList;
    private String phoneNumber;
    private String nameAr;
    private String image;
    private List<User> userList;

    public ClinicDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
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

    public List<User> getDoctorList() {
        return userList;
    }

    public void setDoctorList(List<User> userList) {
        this.userList = userList;
    }

}