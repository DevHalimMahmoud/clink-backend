package com.abdelhalim.egypt.clinics.api.clinic.entity;

import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicUpdate
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String name_ar;
    @Column(nullable = false)
    private String image;
    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> addressSet;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToMany
    @JoinColumn(name = "specialty_id")
    private List<Specialty> specialtySet;
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Doctor> doctorSet;

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

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(List<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public List<Specialty> getSpecialtySet() {
        return specialtySet;
    }

    public void setSpecialtySet(List<Specialty> specialtySet) {
        this.specialtySet = specialtySet;
    }

    public List<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(List<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }
}
