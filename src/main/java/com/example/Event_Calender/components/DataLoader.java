package com.example.Event_Calender.components;

<<<<<<< HEAD

=======
>>>>>>> rebeccaBranch
import com.example.Event_Calender.models.Event;
import com.example.Event_Calender.models.User;
import com.example.Event_Calender.repositories.EventRepository;
import com.example.Event_Calender.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // EVENTS
        // PAINT N SIP
        Event paintNSip = new Event("Paint N Sip", "Paint and Drink together", "Shoreditch", LocalTime.of(19,00,00), LocalTime.of(22,00,00), LocalDate.of(2023,01,06));
        eventRepository.save(paintNSip);

        User rebecca = new User("Rebecca", "rebeccasol@gmail.com");
        rebecca.addEvent(paintNSip);
        userRepository.save(rebecca);

        User rimm = new User("Rimm", "rimmderes@gmail.com");
        rimm.addEvent(paintNSip);
        userRepository.save(rimm);

        // PIZZA MAKING
        Event pizzaMaking = new Event("Pizza Making", "Making Pizza from scratch", "Covent Garden", LocalTime.of(15,00,00), LocalTime.of(18,0,0), LocalDate.of(2022, 12, 16));
        eventRepository.save(pizzaMaking);

        User harry = new User("Harry", "harrym@gmail.com");
        harry.addEvent(pizzaMaking);
        userRepository.save(harry);

        User khalil = new User("Khalil", "khalilh@gmail.com");
        khalil.addEvent(pizzaMaking);
        userRepository.save(khalil);

        // LONDON MOTOR SHOW
        Event londonMotorShow = new Event("LDN Motor Show", "Displaying the finest cars around", "ExCel London", LocalTime.of(10,00,00), LocalTime.of(18, 30, 00), LocalDate.of(2023, 02, 27));
        eventRepository.save(londonMotorShow);

        User zsolt = new User("Zsolt", "zsolt@gmail.com");
        zsolt.addEvent(londonMotorShow);
        userRepository.save(zsolt);

        User colin = new User("Colin", "colinfarqhuar@gmail.com");
        colin.addEvent(londonMotorShow);
        userRepository.save(colin);

        // MANY PEOPLE ATTENDING

        User anna = new User("Anna", "annahen@gmail.com");
        anna.addEvent(pizzaMaking);
        anna.addEvent(paintNSip);
        userRepository.save(anna);

        User ed = new User("Ed", "Ed@gmail.com");
        ed.addEvent(pizzaMaking);
        ed.addEvent(londonMotorShow);
        userRepository.save(ed);
    }



}
