package com.example.Event_Calender.models;

public class BookingDTO {

    private long userId;


    // isolating user id property from user
    public BookingDTO(long userId){
        this.userId = userId;
    }

    public BookingDTO(){

    }

    // GETTERS AND SETTERS

    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId = userId;
    }
}
