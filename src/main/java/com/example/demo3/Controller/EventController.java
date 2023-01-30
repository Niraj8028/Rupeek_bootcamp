package com.example.demo3.Controller;

import com.example.demo3.Models.Event;
import com.example.demo3.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    public List<Event>getEventByInt(@PathVariable String interest) {
        List<Event> events = eventServiceObj.findByInt(interest);
        return events;
    }

    @GetMapping(value = "/event/{city}/{interest}")
    public List<Event>getEventInCityAndInterest(@PathVariable String city,@PathVariable String interest){
        return eventServiceObj.getAllEventInCityAndInterest(city,interest);
    }

     // EventBrite
//     @Autowired
//     RestTemplate restTemplate;
//
//
//    @GetMapping("/eventbrite")
//    public ResponseEntity<?> getEventBrite() {
//        String url = "";
//        String authorization = "";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", authorization);
//        HttpEntity<String> req = new HttpEntity<String>(headers);
//        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, req, Object.class);
//        return response;
//    }

}
