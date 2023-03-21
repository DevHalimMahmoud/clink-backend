package com.abdelhalim.egypt.clinics.api.governorte;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;

import java.util.Collections;
import java.util.List;

public class GovernorateBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static GovernorateDto getDto() {
        GovernorateDto dto = new GovernorateDto();
        return dto;
    }
}