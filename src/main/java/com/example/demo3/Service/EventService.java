package com.example.demo3.Service;

import com.example.demo3.DAO.Eventrepo;
import com.example.demo3.Models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService {

    @Autowired
    Eventrepo eventrepoObj;
    public List<Event> findallEvents() {
        List<Event>events=eventrepoObj.findAll();
        return events;
    }

    public void addevent(Event event) {
        eventrepoObj.save(event);
    }

//    public List<Event> findByCity(String cityName) {
//        List<Event>events=eventrepoObj.findByCityName(cityName);
//        return events;
//    }
}
