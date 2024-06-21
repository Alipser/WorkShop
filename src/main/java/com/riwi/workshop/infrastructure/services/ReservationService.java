package com.riwi.workshop.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.workshop.api.dtos.request.ReservationRequestDto;
import com.riwi.workshop.api.dtos.responses.ReservationResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.IReservationService;

public class ReservationService implements IReservationService{

    @Override
    public Page<ReservationResponseDto> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
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
