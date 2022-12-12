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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User addNewUser(User user) {
        userRepository.save(user);
        return user;
    }
}
