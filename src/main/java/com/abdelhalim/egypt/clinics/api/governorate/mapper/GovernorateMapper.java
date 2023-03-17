package com.abdelhalim.egypt.clinics.api.governorate.mapper;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.governorate.entity.Governorate;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GovernorateMapper extends EntityMapper<GovernorateDto, Governorate> {
}