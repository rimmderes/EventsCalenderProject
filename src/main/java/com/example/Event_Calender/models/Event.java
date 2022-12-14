package com.example.Event_Calender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
// entity defines class can be mapped to a table

@Table(name = "events")
// allows to specify details of the table

    public class Event {

        // indicate id is the primary key of the current entity
        @Id
        // increment value of id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column
        private String eventName;

        @Column
        private String eventDescription;

        @Column
        private String eventLocation;

        @Column
        private LocalTime startTime;

        @Column
        private LocalTime endTime;

        @Column
        private LocalDate date;

        @Column
        private int capacity;


        // create many-to-many relationship table
        @ManyToMany
        @JoinTable(
                name = "users_events",
                // create primary key column
                joinColumns = {@JoinColumn(name = "event_id", nullable = false)},
                // create foreign key column
                inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false)}
        )

        // ignore other event properties from serialisation
        @JsonIgnoreProperties({"events"})


        private List<User> users;

        public Event(String eventName, String eventDescription, String eventLocation, LocalTime startTime, LocalTime endTime, LocalDate date, int capacity) {
            this.eventName = eventName;
            this.eventDescription = eventDescription;
            this.eventLocation = eventLocation;
            this.startTime = startTime;
            this.endTime = endTime;
            this.date = date;
            this.users = new ArrayList<>();
            this.capacity = capacity;
        }

        public Event() {

        }

        // Method

        // add new user
        public void addUser(User user){
            this.users.add(user);
        }

        // GETTERS AND SETTERS


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getEventName() {
            return eventName;
        }

        public void setEventName(String eventName) {
            this.eventName = eventName;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }

        public String getEventLocation() {
            return eventLocation;
        }

        public void setEventLocation(String eventLocation) {
            this.eventLocation = eventLocation;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }
    }

