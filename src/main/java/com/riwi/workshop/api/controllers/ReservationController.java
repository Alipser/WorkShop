package com.riwi.workshop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.workshop.api.dtos.request.BookRequestDto;
import com.riwi.workshop.api.dtos.request.ReservationRequestDto;
import com.riwi.workshop.api.dtos.responses.BookResponseBasic;
import com.riwi.workshop.api.dtos.responses.BookResponseDto;
import com.riwi.workshop.api.dtos.responses.ReservationResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.ILoanService;
import com.riwi.workshop.infrastructure.abstractservices.IReservationService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/reservation")
@AllArgsConstructor
public class ReservationController {    
    
    @Autowired
    private final IReservationService service;

    @GetMapping
    public ResponseEntity<Page<ReservationResponseDto>> getAllBooks(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.service.getAll(page - 1, size));
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationResponseDto> postMethodName(@RequestBody @Validated ReservationRequestDto request) {      
        ReservationResponseDto response = service.create(request);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<ReservationResponseDto> putMethodName(@PathVariable int id, @RequestBody @Validated ReservationRequestDto request){
        ReservationResponseDto response = service.update(request, id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getBy/{id}")
    public ResponseEntity<ReservationResponseDto> getMethodUsingId(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedUsingId(@PathVariable int id) {
        service.delete(id);
      return ResponseEntity.ok("Eliminated correctly");
    }
    
}
