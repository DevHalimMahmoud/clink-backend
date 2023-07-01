package com.abdelhalim.egypt.clinics.entities.patient;

import com.abdelhalim.egypt.clinics.entities.base_user.BaseUser;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends BaseUser {


    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Override
    protected String getRole() {
        return "PATIENT";
    }

    @Override
    public String getUsername() {
        return getPhone();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
