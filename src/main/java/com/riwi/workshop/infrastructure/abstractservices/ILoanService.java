package com.riwi.workshop.infrastructure.abstractservices;

import com.riwi.workshop.api.dtos.request.LoanRequestDto;
import com.riwi.workshop.api.dtos.responses.LoanResponseDto;

public interface ILoanService extends CrudAbstractService<LoanRequestDto, LoanResponseDto, Integer>{

} 