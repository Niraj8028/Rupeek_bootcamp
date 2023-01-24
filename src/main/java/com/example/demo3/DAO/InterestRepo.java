package com.example.demo3.DAO;

import com.example.demo3.Models.Interest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepo extends MongoRepository<Interest,Long> {
}