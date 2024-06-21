package com.riwi.workshop.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.workshop.api.dtos.request.BookRequestDto;
import com.riwi.workshop.api.dtos.responses.BookResponseBasic;
import com.riwi.workshop.api.dtos.responses.BookResponseDto;
import com.riwi.workshop.domain.entities.Book;

import com.riwi.workshop.domain.repositories.BookRepository;
import com.riwi.workshop.infrastructure.abstractservices.IBookService;
import com.riwi.workshop.utils.exceptcions.IdNotFoundException;
import com.riwi.workshop.utils.mappers.BookMapper;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private final BookMapper mapper;

    @Autowired
    private final BookRepository repository;

    @Override
    public Page<BookResponseBasic> getAll(int page, int size) {
        PageRequest pagination = PageRequest.of(page, size);
        Page<BookResponseBasic> response = repository.findAll(pagination).map(entity -> mapper.toResponseBasic(entity));
        return response;        
    }

    @Override
    public BookResponseBasic create(BookRequestDto request) {
        Book entityforsaving = mapper.toEntity(request);
        BookResponseBasic response = mapper.toResponseBasic(repository.save(entityforsaving));
        return response;
    }

    @Override
    public BookResponseBasic update(BookRequestDto request, Integer id) {
        Book entityforsaving = mapper.toEntity(request);
        BookResponseBasic response = mapper.toResponseBasic(repository.save(entityforsaving));
        return response;
    }

    @Override
    public void delete(Integer id) {
        repository.findById(id).orElseThrow(()->new IdNotFoundException("Book"));
        repository.deleteById(id);
    }

    @Override
    public BookResponseBasic getById(Integer id) {
     Book BookEntity = repository.findById(id).orElseThrow(()->new IdNotFoundException("Book"));
        return mapper.toResponseBasic(BookEntity);
    }

    @Override
    public BookResponseDto getFullWithID(Integer id) {
        Book BookEntity = repository.findById(id).orElseThrow(()->new IdNotFoundException("Book"));
        return mapper.toResponse(BookEntity);
    }
    
}
