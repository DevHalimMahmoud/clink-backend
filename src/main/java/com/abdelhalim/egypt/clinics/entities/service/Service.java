package com.abdelhalim.egypt.clinics.entities.service;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.category.Category;
import com.abdelhalim.egypt.clinics.entities.clinic.Clinic;
import com.abdelhalim.egypt.clinics.entities.hospital.Hospital;
import com.abdelhalim.egypt.clinics.entities.laboratory.Laboratory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinTable(name = "base_user_id",
//            joinColumns = @JoinColumn(name = "service_id"),
//            inverseJoinColumns = @JoinColumn(name = "base_user_id"))
//    private BaseUser baseUser;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "laboratory_id")
//    private Laboratory laboratory;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "clinic_id")
//    private Clinic clinic;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hospital_id")
//    private Hospital hospital;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "service_join",
//            joinColumns = @JoinColumn(name = "service_id"),
//            inverseJoinColumns = {
//                    @JoinColumn(name = "clinic_id"),
//                    @JoinColumn(name = "hospital_id"),
//                    @JoinColumn(name = "laboratory_id")
//            }
//    )
//    private Set<BaseUser> baseUsers = new HashSet<>();

    public Service(String name, String nameAr, String description, Double price) {
        this.name = name;
        this.nameAr = nameAr;
        this.description = description;
        this.price = price;
    }

}
