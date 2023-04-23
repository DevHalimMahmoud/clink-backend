package com.abdelhalim.egypt.clinics.api.clinic.mapper;

import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDto;
import com.abdelhalim.egypt.clinics.base.BaseEntityMapper;
import com.abdelhalim.egypt.clinics.entities.Clinic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClinicMapperBase extends BaseEntityMapper<ClinicDto, Clinic> {
}