package com.example.demo3.Controller;

import com.example.demo3.Models.Users;
import com.example.demo3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userServiceObj;

    @PostMapping(path="/add/user")
    public String addUser(@RequestBody Users user){
        userServiceObj.addUser(user);
        return "user added succesfuly";
    }

    @GetMapping(path="/user/{userid}")
    public Optional<Users> getUserById(@PathVariable Long userid){
        Optional<Users> user=userServiceObj.getUserByID(userid);
        return user;
    }

    @GetMapping(path="/users")
    public List<Users> getUsers(){
        List<Users> userlist =userServiceObj.getAllUser();
        return userlist;
    }

    @DeleteMapping(path = "/user/{userid}")
    public String deleteUserById(@PathVariable Long userid ){
        userServiceObj.deleteUserByID(userid);
        return "user deleted succesfully";
    }

}
