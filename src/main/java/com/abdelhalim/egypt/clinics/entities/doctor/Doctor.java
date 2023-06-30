package com.abdelhalim.egypt.clinics.entities.doctor;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.specialty.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Doctor {
    @Id
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageUrl;

    @OneToMany(mappedBy = "doctor")
    private List<Specialty> specialtyList = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "clinic_id")
//    private Clinic clinic;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hospital_id")
//    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "doctor_join",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "base_user_id", referencedColumnName = "id")
            }
    )
    private BaseUser baseUser;
}
