package com.abdelhalim.egypt.clinics.entities.hospital;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.doctor.Doctor;
import com.abdelhalim.egypt.clinics.entities.service.Service;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor

public class Hospital extends BaseUser {

    @OneToMany(mappedBy = "baseUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctorList = new ArrayList<>();

    @OneToMany(mappedBy = "baseUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Service> serviceList = new ArrayList<>();

    @Override
    protected String getRole() {
        return "HOSPITAL";
    }
}
