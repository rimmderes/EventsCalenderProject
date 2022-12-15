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
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@RestController
// create route mapping
@RequestMapping("/events")
public class EventController {

    // call on methods from eventService class (bean)
    // no need to instantiate below object
    @Autowired
    EventService eventService;

    // getting event via id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Event event = eventService.getEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }



    /// Finding all events by Date, if not, find all
    @GetMapping
    public ResponseEntity<List<Event>> getFilteredEventByDate(
            // create a parameter for method
            @RequestParam(required = false, name = "date")
            // express calendar date in standard format in URL
            @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
            LocalDate date
    ) { if(date != null) {        // != "not equal to"
        // get event by date request response
        return new ResponseEntity<>(eventService.findAllEventsByDate(date), HttpStatus.OK);
    }
        // get all events request response
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);

    }



    // Finding out how many days to an event
    @GetMapping(value = "/days-until/{id}")
    public ResponseEntity<?> getDaysUntilEventById(@PathVariable Optional<Long> id) {    // use of optional as null is not appropriate to use in if statement
        if (id.isEmpty()) {
            // NEED TO COME BACK TO ----> THROW EXCEPTION HERE
            return new ResponseEntity<>("this route requires an id", HttpStatus.BAD_REQUEST);
        }
        // get days until event using event id
        String daysUntilEvent = eventService.daysUntilEvent(eventService.getEventById(id.get()).getDate());
        return new ResponseEntity<>(daysUntilEvent, HttpStatus.OK);
    }



    // adding a new event using body in postman
    @PostMapping
    public ResponseEntity<Event> addNewEvent(@RequestBody Event event) {
        Event newEvent = eventService.addNewEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }




    // adding user to event whilst limited to capacity
    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> updateEvent(@RequestBody BookingDTO bookingDTO, @PathVariable Long id) {
        try {
            eventService.addUserToEvent(bookingDTO, id);
            return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }



    // remove event
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> cancelEvent(@PathVariable long id) {
        return new ResponseEntity<>(eventService.deleteEvent(id), HttpStatus.OK);
    }

}
