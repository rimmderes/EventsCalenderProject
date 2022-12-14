package com.example.Event_Calender.services;

import com.example.Event_Calender.models.User;
import com.example.Event_Calender.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id in the user repository
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    // add new user and save to user repository
    public User addNewUser(User user) {
        userRepository.save(user);
        return user;
    }
}
