package com.abdelhalim.egypt.clinics.entities.laboratory;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Laboratory extends BaseUser {

    @Override
    protected String getRole() {
        return "LABORATORY";
    }
}
