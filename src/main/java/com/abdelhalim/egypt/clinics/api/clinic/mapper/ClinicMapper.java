package com.abdelhalim.egypt.clinics.api.clinic.mapper;

import com.abdelhalim.egypt.clinics.api.clinic.dto.ClinicDto;
import com.abdelhalim.egypt.clinics.api.clinic.entity.Clinic;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClinicMapper extends EntityMapper<ClinicDto, Clinic> {
}