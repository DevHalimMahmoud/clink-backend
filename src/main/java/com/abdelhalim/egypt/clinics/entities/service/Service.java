package com.abdelhalim.egypt.clinics.entities.service;

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

    @Column(nullable = false)
    private Boolean isAccepted = false;

    public Service(String name, String nameAr, String description, Double price, Boolean isAccepted) {
        this.name = name;
        this.nameAr = nameAr;
        this.description = description;
        this.price = price;
        this.isAccepted = isAccepted;
    }

}
