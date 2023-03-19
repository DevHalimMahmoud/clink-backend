package com.abdelhalim.egypt.clinics.api.speciality.mapper;

import com.abdelhalim.egypt.clinics.api.speciality.dto.SingleLangSpecialityDto;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SingleLangSpecialityMapper extends EntityMapper<SingleLangSpecialityDto, Specialty> {
}