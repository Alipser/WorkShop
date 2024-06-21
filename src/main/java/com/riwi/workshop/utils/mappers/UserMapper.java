package com.riwi.workshop.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


import com.riwi.workshop.api.dtos.request.UserRequestDto;
import com.riwi.workshop.api.dtos.responses.UserResponseBasic;
import com.riwi.workshop.api.dtos.responses.UserResponseDto;
import com.riwi.workshop.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    User toEntity(UserRequestDto request);

    UserResponseDto toResponse(User entity);

    
    UserResponseBasic toResponseBasic(User entity);

}
