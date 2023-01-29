package com.example.demo3.Controller;

import com.example.demo3.Models.Event;
import com.example.demo3.Models.Interest;
import com.example.demo3.Models.SignIn;
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


    @PostMapping(path="/registerUser") /////////Add users to the database
    public String addUserEnc(@RequestBody Users user){
        userServiceObj.addUserEnc(user);
        return "user added successfully";
    }
    @PostMapping("/signIn")
    public String Authenticate(@RequestBody SignIn signInDetails)
    {
        return userServiceObj.Authenticate(signInDetails);
    }

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
    @PutMapping(path = "/add/interest/{userid}/{text}")
    public String addInterest(@PathVariable Long userid,@PathVariable String text){
        return userServiceObj.Addinterest(userid,text);
    }

    @PutMapping(path = "/register/event/{userid}/{event}")
    public String RegisterEvent(@PathVariable Long userid,@PathVariable String event){
        return userServiceObj.AddEvent(userid,event);
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

    @GetMapping(path = "/user/events/{userid}")
    public List<Event> getRegisteredEvents(@PathVariable Long userid){
        return userServiceObj.getRegEvents(userid);

    }

    @GetMapping(path = "/user/interests/{userid}")
    public List<Interest> get(@PathVariable Long userid){
        return userServiceObj.getInterests(userid);

    }



}
