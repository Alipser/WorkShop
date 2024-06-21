package com.riwi.workshop.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dtos.request.ReservationRequestDto;

import com.riwi.workshop.api.dtos.responses.ReservationResponseDto;

import com.riwi.workshop.domain.repositories.ReservationRepository;
import com.riwi.workshop.infrastructure.abstractservices.IReservationService;

import com.riwi.workshop.utils.mappers.ReservationMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService implements IReservationService{

    @Autowired
    private final ReservationMapper mapper;

    @Autowired
    private final ReservationRepository repository;

    @Override
    public Page<ReservationResponseDto> getAll(int page, int size) {
        PageRequest pagination = PageRequest.of(page, size);
        Page<ReservationResponseDto> response = repository.findAll(pagination).map(entity -> mapper.toResponse(entity));
        return response;  
    }

    @Override
    public ReservationResponseDto create(ReservationRequestDto request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ReservationResponseDto update(ReservationRequestDto request, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ReservationResponseDto getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
