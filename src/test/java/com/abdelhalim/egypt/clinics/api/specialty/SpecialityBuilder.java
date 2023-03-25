package com.abdelhalim.egypt.clinics.api.specialty;

import com.abdelhalim.egypt.clinics.api.specialty.dto.SpecialtyDto;

import java.util.Collections;
import java.util.List;

public class SpecialityBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static SpecialtyDto getDto() {
        SpecialtyDto dto = new SpecialtyDto();
        return dto;
    }
}