package com.abdelhalim.egypt.clinics.entities.governorate;

import com.abdelhalim.egypt.clinics.entities.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Governorate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, name = "name_ar", length = 50)
    private String nameAr;

    @OneToMany(mappedBy = "governorate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addressSet;

}
