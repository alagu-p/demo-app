package com.example.demoapp.controller;

import com.example.demoapp.model.Users;
import com.example.demoapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;
    @PostMapping
    public ResponseEntity<?> createuser(@RequestBody Users user){

        usersRepository.save(user);
        return new ResponseEntity<String>("User Saved Successfully", HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getuser(@PathVariable Long id){
        Optional<Users> users=usersRepository.findById(id);

        return new ResponseEntity<Users>(users.orElseThrow(),HttpStatus.OK);


    }
}
