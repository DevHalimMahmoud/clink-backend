package com.abdelhalim.egypt.clinics.api.address.mapper;

import com.abdelhalim.egypt.clinics.api.address.dto.AddressDto;
import com.abdelhalim.egypt.clinics.base.BaseEntityMapper;
import com.abdelhalim.egypt.clinics.entities.address.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapperBase extends BaseEntityMapper<AddressDto, Address> {
}