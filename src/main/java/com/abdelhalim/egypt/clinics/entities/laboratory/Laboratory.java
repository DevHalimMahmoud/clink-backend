package com.abdelhalim.egypt.clinics.entities.laboratory;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.UUID;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor

public class Laboratory extends BaseUser {



    @Override
    protected String getRole() {
        return "LABORATORY";
    }
}
