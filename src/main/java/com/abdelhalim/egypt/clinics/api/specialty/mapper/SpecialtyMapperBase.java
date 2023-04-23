package com.abdelhalim.egypt.clinics.api.specialty.mapper;

import com.abdelhalim.egypt.clinics.api.specialty.dto.SpecialtyDto;
import com.abdelhalim.egypt.clinics.base.BaseEntityMapper;
import com.abdelhalim.egypt.clinics.entities.Specialty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialtyMapperBase extends BaseEntityMapper<SpecialtyDto, Specialty> {
}