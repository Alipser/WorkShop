package com.riwi.workshop.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


import com.riwi.workshop.api.dtos.request.BookRequestDto;
import com.riwi.workshop.api.dtos.responses.BookResponseBasic;
import com.riwi.workshop.api.dtos.responses.BookResponseDto;
import com.riwi.workshop.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Book toEntity(BookRequestDto request);

    
    BookResponseBasic toResponseBasic(Book entity);

    BookResponseDto toResponse(Book entity);
}