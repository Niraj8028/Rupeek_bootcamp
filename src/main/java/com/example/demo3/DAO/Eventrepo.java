package com.example.demo3.DAO;

import com.example.demo3.Models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Eventrepo extends MongoRepository<Event,Long> {
//    List<Event> findByCityName(String cityName);
}
