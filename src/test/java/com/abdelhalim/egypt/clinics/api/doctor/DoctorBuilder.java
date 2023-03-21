package com.abdelhalim.egypt.clinics.api.doctor;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;

import java.util.Collections;
import java.util.List;

public class DoctorBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static DoctorDto getDto() {
        DoctorDto dto = new DoctorDto();
        return dto;
    }
}