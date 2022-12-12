package com.example.Event_Calender.repositories;

import com.example.Event_Calender.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
