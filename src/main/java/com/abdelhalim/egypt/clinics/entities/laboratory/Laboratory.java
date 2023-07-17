package com.abdelhalim.egypt.clinics.entities.laboratory;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import com.abdelhalim.egypt.clinics.entities.service.Service;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor

public class Laboratory extends BaseUser {

    @OneToMany(mappedBy = "laboratory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Service> serviceList = new ArrayList<>();

    @Override
    protected String getRole() {
        return "LABORATORY";
    }
}
