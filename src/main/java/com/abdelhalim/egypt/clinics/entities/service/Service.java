package com.abdelhalim.egypt.clinics.entities.service;

import com.abdelhalim.egypt.clinics.entities.category.Category;
import com.abdelhalim.egypt.clinics.entities.clinic.Clinic;
import com.abdelhalim.egypt.clinics.entities.hospital.Hospital;
import com.abdelhalim.egypt.clinics.entities.laboratory.Laboratory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nameAr;

    @Column(nullable = false)
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "service_clinic_join",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
            }
    )
    private Clinic clinic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "service_laboratory_join",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "laboratory_id", referencedColumnName = "id")
            }
    )
    private Laboratory laboratory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "service_hospital_join",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
            }
    )
    private Hospital hospital;

    public Service(String name, String nameAr, String description, Double price) {
        this.name = name;
        this.nameAr = nameAr;
        this.description = description;
        this.price = price;
    }

}
