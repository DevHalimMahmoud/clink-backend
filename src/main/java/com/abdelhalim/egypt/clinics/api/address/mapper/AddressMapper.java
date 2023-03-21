package com.abdelhalim.egypt.clinics.api.address.mapper;

import com.abdelhalim.egypt.clinics.api.address.dto.AddressDto;
import com.abdelhalim.egypt.clinics.api.address.entity.Address;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDto, Address> {
}