package com.riwi.workshop.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.workshop.api.dtos.request.LoanRequestDto;
import com.riwi.workshop.api.dtos.responses.LoanResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.ILoanService;

public class LoanService implements ILoanService{

    @Override
    public Page<LoanResponseDto> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public LoanResponseDto create(LoanRequestDto request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public LoanResponseDto update(LoanRequestDto request, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public LoanResponseDto getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
