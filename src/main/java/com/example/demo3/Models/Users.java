package com.example.demo3.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="users")
public class Users {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
//    @DBRef
    private List<String> interest;

    public List<String> getInterest() {
        return interest;
    }

    public Users(long id, String firstName, String lastName, String email,List<String> interest) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.interest = interest;
    }

    public void setInterest(List<String>interest) {
        this.interest = interest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
