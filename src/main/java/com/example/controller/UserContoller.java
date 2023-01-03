package com.example.controller;

import com.example.dto.UserRequest;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserContoller {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> saveUserEntity(@RequestBody @Valid UserRequest request){
        return new ResponseEntity<>(service.saveUser(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(service.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.ok(service.   GetUserByUserId(id));
    }

}
