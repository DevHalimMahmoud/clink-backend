package com.abdelhalim.egypt.clinics.api.speciality;

import com.abdelhalim.egypt.clinics.api.speciality.dto.SpecialityDto;

import java.util.Collections;
import java.util.List;

public class SpecialityBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static SpecialityDto getDto() {
        SpecialityDto dto = new SpecialityDto();
        return dto;
    }
}