package com.abdelhalim.egypt.clinics.entities.hospital;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.doctor.Doctor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor

public class Hospital extends BaseUser {



    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctorList = new ArrayList<>();

    @Override
    protected String getRole() {
        return "HOSPITAL";
    }
}
