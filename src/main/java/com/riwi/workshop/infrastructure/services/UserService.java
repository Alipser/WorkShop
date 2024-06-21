package com.riwi.workshop.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dtos.request.UserRequestDto;
import com.riwi.workshop.api.dtos.responses.UserResponseBasic;
import com.riwi.workshop.api.dtos.responses.UserResponseDto;
import com.riwi.workshop.domain.entities.User;
import com.riwi.workshop.domain.repositories.UserRepository;
import com.riwi.workshop.infrastructure.abstractservices.IUserService;
import com.riwi.workshop.utils.exceptcions.IdNotFoundException;
import com.riwi.workshop.utils.mappers.UserMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRespository;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public Page<UserResponseBasic> getAll(int page, int size) {
        PageRequest pagination = PageRequest.of(page, size);
        Page<UserResponseBasic> response = userRespository.findAll(pagination).map(user -> userMapper.toResponseBasic(user));
        return response;
    }

    @Override
    public UserResponseBasic create(UserRequestDto request) {
        User entityforsaving = userMapper.toEntity(request);
        UserResponseBasic response = userMapper.toResponseBasic(userRespository.save(entityforsaving));
        return response;
    }

    @Override
    public UserResponseBasic update(UserRequestDto request, Integer id) {
        User entityforsaving = userMapper.toEntity(request);
        UserResponseBasic response = userMapper.toResponseBasic(userRespository.save(entityforsaving));
        return response;
    }

    @Override
    public void delete(Integer id) {
        userRespository.findById(id).orElseThrow(()->new IdNotFoundException("User"));
        userRespository.deleteById(id);
    }

    @Override
    public UserResponseBasic getById(Integer id) {
        User userEntity = userRespository.findById(id).orElseThrow(()->new IdNotFoundException("User"));
        return userMapper.toResponseBasic(userEntity);
    }

    @Override
    public UserResponseDto getFullWithID(Integer id) {
        User userEntity = userRespository.findById(id).orElseThrow(()->new IdNotFoundException("User"));
        return userMapper.toResponse(userEntity);
    }
}