package com.abdelhalim.egypt.clinics.api.specialty.mapper;

import com.abdelhalim.egypt.clinics.api.specialty.dto.SpecialtyDto;
import com.abdelhalim.egypt.clinics.api.specialty.entity.Specialty;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper extends EntityMapper<SpecialtyDto, Specialty> {
}