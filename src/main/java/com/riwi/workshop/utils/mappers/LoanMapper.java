package com.riwi.workshop.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.riwi.workshop.api.dtos.request.LoanRequestDto;
import com.riwi.workshop.api.dtos.responses.LoanResponseDto;
import com.riwi.workshop.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    @Mappings({
        @Mapping(target ="user.id", source = "userId"),
        @Mapping(target ="book.id", source = "bookId")
    })
    Loan toEntity(LoanRequestDto request);

    
    LoanResponseDto toResponse(Loan entity);
}