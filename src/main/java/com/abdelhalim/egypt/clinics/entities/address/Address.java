package com.abdelhalim.egypt.clinics.entities.address;

import com.abdelhalim.egypt.clinics.entities.clinic.Clinic;
import com.abdelhalim.egypt.clinics.entities.governorate.Governorate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "name_ar")
    private String nameAr;
    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

}
