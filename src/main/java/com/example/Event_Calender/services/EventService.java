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

    // create method to get all events in the event repository
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    // get events using their ids
    public Event getEventById(long id) {
        return eventRepository.findById(id).get();
    }

    // add a new event and save to event repository
    public Event addNewEvent(Event event){
        eventRepository.save(event);
        return event;
    }

    // METHODS

    // adding a new user to an event
    public void addUserToEvent(BookingDTO bookingDTO, Long id) throws Exception {
        // exception = create a message which is a human-readable error description
        // instantiate an existing event
        // find an event id in the event repository and 'get' it
        Event event = eventRepository.findById(id).get();
        // check if there is space for new user
        if (event.getCapacity() <= event.getUsers().size()) {
            throw new Exception (String.format(("Sorry, event is full.")));
        }
        // get user id out of booking dto
        long userId = bookingDTO.getUserId();
        // find appropriate user via id
        User user = userService.getUserById(userId);
        // then add user to event
        event.addUser(user);
        // save event with new user to the event repository
        eventRepository.save(event);

    }


    // create method to show countdown until event begins
    public String daysUntilEvent(LocalDate date){
        // return date difference between two dates in years, months, days
        Period period = Period.between(LocalDate.now(), date);
        // show countdown until the event to user
        return String.format("%s years, %s months and %s days until the event!", period.getYears(), period.getMonths(), period.getDays());

    }

    // delete an event from the repository using its id
    public String deleteEvent(long id) {
        eventRepository.deleteById(id);
        return "Event successfully cancelled.";
    }

    // find an event by date
    public List<Event> findAllEventsByDate(LocalDate date) {
        return eventRepository.findByDateEquals(date);
    }


}
