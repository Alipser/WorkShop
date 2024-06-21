package com.riwi.workshop.api.errorhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.workshop.api.dtos.errors.BaseErrorResponse;
import com.riwi.workshop.api.dtos.errors.ErrorResponse;
import com.riwi.workshop.api.dtos.errors.ListErrorsResponse;
import com.riwi.workshop.utils.exceptcions.IdNotFoundException;
import com.riwi.workshop.utils.exceptcions.IdNotMatchedException;



@RestControllerAdvice
// Error status
@ResponseStatus(code = HttpStatus.BAD_REQUEST )
public class BadRequestController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handlerBadRequest(MethodArgumentNotValidException exception){
        List<String> errors = new ArrayList<>();
        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        BaseErrorResponse baseErrorResponse = ListErrorsResponse.builder()
                                            .code(HttpStatus.BAD_REQUEST.value())
                                            .status(HttpStatus.BAD_REQUEST.name())
                                            .errors(errors)
                                            .build();
        return baseErrorResponse;
    }

    @ExceptionHandler(IdNotFoundException.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundException exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(IdNotMatchedException.class)
    public BaseErrorResponse handleIdNotMatched(IdNotMatchedException exception) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

}