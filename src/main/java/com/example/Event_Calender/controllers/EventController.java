package com.example.Event_Calender.controllers;

import com.example.Event_Calender.models.Event;
import com.example.Event_Calender.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Event event = eventService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> addNewEvent(@RequestBody Event event) {
        Event newEvent = eventService.addNewEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
