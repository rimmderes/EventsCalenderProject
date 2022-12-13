package com.example.Event_Calender.controllers;

import com.example.Event_Calender.models.User;
import com.example.Event_Calender.repositories.UserRepository;
import com.example.Event_Calender.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired // (no need to instantiate below object).
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping // creates 'Get' request.
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<User> addNewUser(@RequestBody User user){
        User savedUser = userService.addNewUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


}
