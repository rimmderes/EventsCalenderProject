package com.example.Event_Calender.controllers;

import com.example.Event_Calender.models.BookingDTO;
import com.example.Event_Calender.models.Event;
import com.example.Event_Calender.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

//    @GetMapping
//    public ResponseEntity<List<Event>> getAllEvents() {
//        List<Event> events = eventService.getAllEvents();
//        return new ResponseEntity<>(events, HttpStatus.OK);
//    }

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event, @PathVariable Long id) {
        eventService.addUserToEvent(event, id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelEvent(@PathVariable long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

<<<<<<< HEAD
//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Event> addUserToEvent(@PathVariable long id, @RequestBody BookingDTO bookingDTO) {
//        long userId = bookingDTO.getUserId();
//        Event updatedEvent = eventService.addUserToEvent(id, userId);
//        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
//    }
=======
    // Extension
    // Finding events by Date
    @GetMapping
    public ResponseEntity<List<Event>> getFilteredEventByDate(
            @RequestParam(required = false, name = "date")
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
            LocalDate date
            ) { if(date != null) {
        return new ResponseEntity<>(eventService.findAllEventsByDate(date), HttpStatus.OK);
    }
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);

    }


>>>>>>> rebeccaBranch

}
