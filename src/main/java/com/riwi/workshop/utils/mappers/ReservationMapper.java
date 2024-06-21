package com.riwi.workshop.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


import com.riwi.workshop.api.dtos.request.ReservationRequestDto;
import com.riwi.workshop.api.dtos.responses.ReservationResponseDto;
import com.riwi.workshop.domain.entities.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "book.id", source = "bookId")
    Reservation toEntity(ReservationRequestDto request);

    
    ReservationResponseDto toResponse(Reservation entity);
}