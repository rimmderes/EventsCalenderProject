package com.example.Event_Calender.repositories;

import com.example.Event_Calender.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // finds all events equal to the date given
    List<Event> findByDateEquals(LocalDate date);
}
