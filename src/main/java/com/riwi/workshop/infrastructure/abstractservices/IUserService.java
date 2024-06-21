package com.riwi.workshop.infrastructure.abstractservices;

import com.riwi.workshop.api.dtos.request.UserRequestDto;
import com.riwi.workshop.api.dtos.responses.UserResponseBasic;
import com.riwi.workshop.api.dtos.responses.UserResponseDto;

public interface IUserService extends CrudAbstractService<UserRequestDto, UserResponseBasic, Integer> {

    public UserResponseDto getFullWithID(Integer id);
    
}
