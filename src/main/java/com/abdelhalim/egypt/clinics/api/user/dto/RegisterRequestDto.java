package com.abdelhalim.egypt.clinics.api.user.dto;

import com.abdelhalim.egypt.clinics.entities.user.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    private String name;
    private String nameAr;
    private String image;
    private String email;
    private String password;
    private List<Long> specialityIds;
    private Gender gender;

}