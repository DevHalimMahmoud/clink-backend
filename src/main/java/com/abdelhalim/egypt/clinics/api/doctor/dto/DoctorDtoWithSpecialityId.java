package com.abdelhalim.egypt.clinics.api.doctor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDtoWithSpecialityId {

    private String name;
    private String nameAr;
    private String image;
    private String gender;
    private List<Long> specialityIds;

}