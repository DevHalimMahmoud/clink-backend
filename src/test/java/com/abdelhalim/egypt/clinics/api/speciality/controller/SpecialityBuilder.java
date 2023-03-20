package com.abdelhalim.egypt.clinics.api.speciality.controller;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.speciality.dto.MultiLangSpecialityDto;

import java.util.Collections;
import java.util.List;

public class SpecialityBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static MultiLangSpecialityDto getDto() {
        MultiLangSpecialityDto dto = new MultiLangSpecialityDto();
        return dto;
    }
}