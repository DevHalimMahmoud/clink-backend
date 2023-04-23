package com.abdelhalim.egypt.clinics.api.governorate.mapper;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.entities.Governorate;
import com.abdelhalim.egypt.clinics.base.BaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GovernorateMapperBase extends BaseEntityMapper<GovernorateDto, Governorate> {
}