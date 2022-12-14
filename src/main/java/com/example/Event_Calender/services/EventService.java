package com.example.Event_Calender.services;

import com.example.Event_Calender.models.BookingDTO;
import com.example.Event_Calender.models.Event;
import com.example.Event_Calender.models.User;
import com.example.Event_Calender.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserService userService;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById(long id) {
        return eventRepository.findById(id).get();
    }

    public Event addNewEvent(Event event){
        eventRepository.save(event);
        return event;
    }

    // adding a new user to an event
    // exception = create a message which is a human-readable error description
    public void addUserToEvent(BookingDTO bookingDTO, Long id) throws Exception {
        // instantiate an existing event
        Event event = eventRepository.findById(id).get();
        // check if the there is space for new user
        if (event.getCapacity() <= event.getUsers().size()) {
            throw new Exception (String.format(("Sorry, event is full.")));
        }
        // get id out of booking dto
        long userId = bookingDTO.getUserId();
        // find appropriate user
        User user = userService.getUserById(userId);
        // then add user to event
        event.addUser(user);
        // eventRepository.save()
        eventRepository.save(event);

    }

    public String daysUntilEvent(LocalDate date){
        Period period = Period.between(LocalDate.now(), date);
        // 00 years 2 months and 2 days until the event
        return String.format("%s years, %s months and %s days until the event!", period.getYears(), period.getMonths(), period.getDays());

    }



    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findAllEventsByDate(LocalDate date) {
        return eventRepository.findByDateEquals(date);
    }


}
