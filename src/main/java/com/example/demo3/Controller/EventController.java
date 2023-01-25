package com.example.demo3.Controller;

import com.example.demo3.Models.Event;
import com.example.demo3.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EventController {
    @Autowired
    EventService eventServiceObj;

    @GetMapping(value = "/events")
    public List<Event> getEvents(){
        return eventServiceObj.getEvent();
    }

    @PostMapping(value = "/add/event")
    public String addEvent(@RequestBody Event event){
        eventServiceObj.addevent(event);
        return "Event added succesfully";
    }
     @GetMapping(value = "/event/{city_name}")
     public List<Event>getEventByCity(@PathVariable String city_name){
        List<Event>events= eventServiceObj.findByCity(city_name);
        return events;
     }

    @GetMapping(value = "/events/{interest}")
    public List<Event>getEventByInt(@PathVariable String interest){
        List<Event>events= eventServiceObj.findByInt(interest);
        return events;
    }


}
