package com.abdelhalim.egypt.clinics.entities.address;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.governorate.Governorate;
import com.abdelhalim.egypt.clinics.entities.patient.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

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

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "address_join",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "id", referencedColumnName = "id"),

            }
    )
    private BaseUser baseUsers;

}
