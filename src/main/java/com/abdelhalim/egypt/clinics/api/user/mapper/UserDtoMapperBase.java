package com.abdelhalim.egypt.clinics.api.user.mapper;

import com.abdelhalim.egypt.clinics.api.user.dto.UserDto;
import com.abdelhalim.egypt.clinics.base.BaseEntityMapper;
import com.abdelhalim.egypt.clinics.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapperBase extends BaseEntityMapper<UserDto, User> {
}