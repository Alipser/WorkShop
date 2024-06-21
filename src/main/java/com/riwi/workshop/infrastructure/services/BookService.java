package com.riwi.workshop.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.workshop.api.dtos.request.BookRequestDto;
import com.riwi.workshop.api.dtos.responses.BookResponseBasic;
import com.riwi.workshop.api.dtos.responses.BookResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.IBookService;

public class BookService implements IBookService {

    @Override
    public Page<BookResponseBasic> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public BookResponseBasic create(BookRequestDto request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public BookResponseBasic update(BookRequestDto request, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public BookResponseBasic getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public BookResponseDto getFullWithID(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFullWithID'");
    }
    
}
