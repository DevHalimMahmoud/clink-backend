package com.abdelhalim.egypt.clinics.entities.specialty;

import com.abdelhalim.egypt.clinics.entities.doctor.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, name = "name_ar", length = 50)
    private String nameAr;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, optional = false, targetEntity = Doctor.class)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

}
