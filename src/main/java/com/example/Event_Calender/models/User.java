package com.example.Event_Calender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")

    private String name;
    @Column (name = "emailAddress")
    private String emailAddress;

    @ManyToMany
    @JoinTable (
            name = "users_events",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "event_id", nullable = false)}
    )

    @JsonIgnoreProperties({"users"})
    private List<Event> events;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.events = new ArrayList<>();
    }

    public User(){}

    // METHOD

    public void addEvent(Event event) {
        this.events.add(event);
    }


    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}



