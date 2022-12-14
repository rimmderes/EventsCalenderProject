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

    public void addUserToEvent(BookingDTO bookingDTO, Long id) throws Exception {
        Event event = eventRepository.findById(id).get();
        // check if the there is space for new user
        if (event.getCapacity() <= event.getUsers().size()) {
            throw new Exception("Sorry, event is full.");
        }
        // get id out of booking dto
        long userId = bookingDTO.getUserId();
        // find appropriate user (userService.findById)
        User user = userService.getUserById(userId);
        // once hve that user must have event.addByUser
        event.addUser(user);
        // eventRepository.save()
        eventRepository.save(event);

    }

    public long daysUntilEvent(LocalDate date){
//        Period period = Period.between(LocalDate.now(), date);
//        return String.format(period.getDays())
        long daysUntil = ChronoUnit.DAYS.between(LocalDate.now(), date);
        return daysUntil;

    }



    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findAllEventsByDate(LocalDate date) {
        return eventRepository.findByDateEquals(date);
    }


}
