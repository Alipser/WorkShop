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

import com.riwi.workshop.api.dtos.request.LoanRequestDto;
import com.riwi.workshop.api.dtos.responses.LoanResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.ILoanService;


import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/loan")
@AllArgsConstructor
public class LoanController {

    @Autowired
    private final ILoanService service;

    @GetMapping
    public ResponseEntity<Page<LoanResponseDto>> getAllBooks(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.service.getAll(page - 1, size));
    }

    @PostMapping("/create")
    public ResponseEntity<LoanResponseDto> postMethodName(@RequestBody @Validated LoanRequestDto request) {      
        LoanResponseDto response = service.create(request);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<LoanResponseDto> putMethodName(@PathVariable int id, @RequestBody @Validated LoanRequestDto request){
        LoanResponseDto response = service.update(request, id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getBy/{id}")
    public ResponseEntity<LoanResponseDto> getMethodUsingId(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedUsingId(@PathVariable int id) {
        service.delete(id);
      return ResponseEntity.ok("Eliminated correctly");
    }
    
}
