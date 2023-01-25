package com.example.demo3.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="Events")
public class Event {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Id
    //private long event_id;
    private String eventName;
    private String city;
    private String Date;
    private List<String> interest;

//    public Event(long event_id, String eventName, String city, String date, List<String> interest) {
//        //this.event_id = event_id;
//        this.eventName = eventName;
//        this.city = city;
//        Date = date;
//        this.interest = interest;
//    }

//    public long getEvent_id() {
//        return event_id;
//    }

//    public void setEvent_id(long event_id) {
//        this.event_id = event_id;
//    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Event{" +
//                "event_id=" + event_id +
                ", eventName='" + eventName + '\'' +
                ", city='" + city + '\'' +
                ", Date='" + Date + '\'' +
                ", interest=" + interest +
                '}';
    }
}
