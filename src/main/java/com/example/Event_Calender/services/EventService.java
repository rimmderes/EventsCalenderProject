package com.example.Event_Calender.services;

import com.example.Event_Calender.models.BookingDTO;
import com.example.Event_Calender.models.Event;
import com.example.Event_Calender.models.User;
import com.example.Event_Calender.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public void addUserToEvent(BookingDTO bookingDTO, Long id) throws Exception {
        Event event = eventRepository.findById(id).get();

        if (event.getCapacity() <= 0) {
            throw new Exception("Sorry, event is full.");
        }

        // get id out of booking dto
        // find appropriate user (userService.findById)
        // once hve that user must have event.addByUser
        // update capacity - can work out with how many people are in the event
        // eventRepository.save()

        eventRepository.save(event);

//        if (addUserToEvent.getCapacity() > 0) {
//            addUserToEvent.setCapacity(addUserToEvent.getCapacity()-1);
//            eventRepository.save(addUserToEvent);
//        } else {
//            throw new Exception("Sorry, event is full.");
//        }

    }

//    public Event addUserToEvent(long eventId, long userId) {
//        // instantiating an event that already exists in the database
//        Event event = eventRepository.findById(eventId).get();
//        // instantiating a user utilising their id
//        User user = userService.getUserById(userId);
//        // instantiating users into getUsers event method
//        List<User> users = event.getUsers();
//        users.add(user);
//        // setting users with events
//        event.setUsers(users);
//        eventRepository.save(event);
//        return event;
//    }

    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findAllEventsByDate(LocalDate date) {
        return eventRepository.findByDateEquals(date);
    }


}
