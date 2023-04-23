package com.abdelhalim.egypt.clinics.api.user.mapper;

import com.abdelhalim.egypt.clinics.api.user.dto.UserDto;
import com.abdelhalim.egypt.clinics.api.user.entity.User;
import com.abdelhalim.egypt.clinics.base.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper extends EntityMapper<UserDto, User> {
}