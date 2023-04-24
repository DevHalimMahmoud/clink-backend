package com.abdelhalim.egypt.clinics.api.doctor.mapper;

import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.base.BaseEntityMapper;
import com.abdelhalim.egypt.clinics.entities.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper extends BaseEntityMapper<DoctorDto, User> {

}