package com.abdelhalim.egypt.clinics.api.doctor.mapper;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorDtoMapper extends EntityMapper<DoctorDto, Doctor> {
}