package com.riwi.workshop.infrastructure.abstractservices;

import com.riwi.workshop.api.dtos.request.ReservationRequestDto;
import com.riwi.workshop.api.dtos.responses.ReservationResponseDto;

public interface IReservationService extends CrudAbstractService <ReservationRequestDto, ReservationResponseDto, Integer> {
    
}
