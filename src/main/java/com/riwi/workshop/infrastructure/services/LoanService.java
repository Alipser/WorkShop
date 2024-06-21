package com.riwi.workshop.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dtos.request.LoanRequestDto;
import com.riwi.workshop.api.dtos.responses.LoanResponseDto;

import com.riwi.workshop.domain.repositories.LoanRepository;
import com.riwi.workshop.infrastructure.abstractservices.ILoanService;

import com.riwi.workshop.utils.mappers.LoanMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class LoanService implements ILoanService{

    
    @Autowired
    private final LoanMapper mapper;

    @Autowired
    private final LoanRepository repository;

    @Override
    public Page<LoanResponseDto> getAll(int page, int size) {
        PageRequest pagination = PageRequest.of(page, size);
        Page<LoanResponseDto> response = repository.findAll(pagination).map(entity -> mapper.toResponse(entity));
        return response;  
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
