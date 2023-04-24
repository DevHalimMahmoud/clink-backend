package com.abdelhalim.egypt.clinics.entities.clinic;

import com.abdelhalim.egypt.clinics.entities.address.Address;
import com.abdelhalim.egypt.clinics.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {
    @Id
    private Long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, name = "name_ar")
    private String nameAr;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;
    @OneToMany
    @JoinColumn(name = "clinic_id")
    private List<Address> addressList;
    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "clinic_id")
    private List<User> userList;
}
