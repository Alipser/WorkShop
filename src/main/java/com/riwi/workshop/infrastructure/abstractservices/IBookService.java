package com.riwi.workshop.infrastructure.abstractservices;

import com.riwi.workshop.api.dtos.request.BookRequestDto;
import com.riwi.workshop.api.dtos.responses.BookResponseBasic;
import com.riwi.workshop.api.dtos.responses.BookResponseDto;


public interface IBookService extends CrudAbstractService<BookRequestDto, BookResponseBasic, Integer>{

    public BookResponseDto getFullWithID(Integer id);

} 