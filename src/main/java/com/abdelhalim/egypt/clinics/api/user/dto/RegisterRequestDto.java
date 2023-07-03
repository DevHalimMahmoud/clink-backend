package com.abdelhalim.egypt.clinics.api.user.dto;

import com.abdelhalim.egypt.clinics.entities.patient.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    private String name;
    private String image;
    private String phone;
    private String email;
    private String password;
    private Gender gender;

}