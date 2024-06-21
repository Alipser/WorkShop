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

import com.riwi.workshop.api.dtos.request.UserRequestDto;
import com.riwi.workshop.api.dtos.responses.UserResponseBasic;
import com.riwi.workshop.api.dtos.responses.UserResponseDto;
import com.riwi.workshop.infrastructure.abstractservices.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseBasic>> getAllUsers(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.userService.getAll(page - 1, size));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseBasic> postMethodName(@RequestBody @Validated UserRequestDto request) {      
        UserResponseBasic response = userService.create(request);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<UserResponseBasic> putMethodName(@PathVariable int id, @RequestBody @Validated UserRequestDto request){
        UserResponseBasic response = userService.update(request, id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getBy/{id}")
    public ResponseEntity<UserResponseBasic> getMethodUsingId(@PathVariable int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/getBy/{id}/full")
    public ResponseEntity<UserResponseDto> getMethodIdFull(@PathVariable int id) {
        return ResponseEntity.ok(userService.getFullWithID(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedUsingId(@PathVariable int id) {
        userService.delete(id);
      return ResponseEntity.ok("Eliminated correctly");
    }
}