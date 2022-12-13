package com.example.Event_Calender.services;

import com.example.Event_Calender.models.Event;
import com.example.Event_Calender.models.User;
import com.example.Event_Calender.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addUserToEvent(Event event, Long id) {
        Event addUserToEvent = eventRepository.findById(id).get();
        addUserToEvent.setEventName(event.getEventName());
        addUserToEvent.setEventDescription(event.getEventDescription());
        addUserToEvent.setEventLocation(event.getEventLocation());
        addUserToEvent.setStartTime(event.getStartTime());
        addUserToEvent.setEndTime(event.getEndTime());
        addUserToEvent.setDate(event.getDate());
        addUserToEvent.setUsers(event.getUsers());
        eventRepository.save(addUserToEvent);
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


}
