package com.example.Event_Calender.models;

public class BookingDTO {

    private long userId;

    public BookingDTO(long userId){
        this.userId = userId;
    }
    public BookingDTO(){

    }
    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId = userId;
    }
}
