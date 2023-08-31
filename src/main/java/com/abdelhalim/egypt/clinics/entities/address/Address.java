package com.abdelhalim.egypt.clinics.entities.address;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.governorate.Governorate;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String latitude;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String longitude;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, optional = false, targetEntity = Governorate.class)
    @JoinColumn(name = "governorate_id", nullable = false)
    private Governorate governorate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, optional = false, targetEntity = BaseUser.class)
    @JoinTable(
            name = "address_join",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "base_user_id", referencedColumnName = "id")
            }
    )
    private BaseUser baseUser;

}
