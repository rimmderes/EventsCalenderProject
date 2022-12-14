package com.example.Event_Calender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")

    public class Event {

        @Id
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

        @ManyToMany
        @JoinTable(
                name = "users_events",
                joinColumns = {@JoinColumn(name = "event_id", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false)}
        )

        @JsonIgnoreProperties({"events"})
        //

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

