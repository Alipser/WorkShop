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

import com.riwi.workshop.api.dtos.responses.BookResponseBasic;
import com.riwi.workshop.api.dtos.responses.BookResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.IBookService;


import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
public class BookController {

    @Autowired
    private final IBookService bookService;

    @GetMapping
    public ResponseEntity<Page<BookResponseBasic>> getAllBooks(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.bookService.getAll(page - 1, size));
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponseBasic> postMethodName(@RequestBody @Validated BookRequestDto request) {      
        BookResponseBasic response = bookService.create(request);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<BookResponseBasic> putMethodName(@PathVariable int id, @RequestBody @Validated BookRequestDto request){
        BookResponseBasic response = bookService.update(request, id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getBy/{id}")
    public ResponseEntity<BookResponseBasic> getMethodUsingId(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping("/getBy/{id}/reservations")
    public ResponseEntity<BookResponseDto> getMethodIdFull(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getFullWithID(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedUsingId(@PathVariable int id) {
        bookService.delete(id);
      return ResponseEntity.ok("Eliminated correctly");
    }

}
