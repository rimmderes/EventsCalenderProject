package com.example.Event_Calender.repositories;

import com.example.Event_Calender.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends JpaRepository <User, Long> {
}
