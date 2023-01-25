package com.example.demo3.Service;

import com.example.demo3.DAO.Eventrepo;
import com.example.demo3.DAO.InterestRepo;
import com.example.demo3.DAO.UserRepo;
import com.example.demo3.Models.Event;
import com.example.demo3.Models.Interest;
import com.example.demo3.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepo userRepoObj;

    @Autowired
    Eventrepo eventrepoobj;

    @Autowired
    InterestRepo interestRepoObj;
    public void addUser(Users user) {
        userRepoObj.save(user);
    }


    public Optional<Users> getUserByID(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        return user;
    }

    public List<Users> getAllUser() {
        return userRepoObj.findAll();
    }


    public void deleteUserByID(Long userid) {
        userRepoObj.deleteById(userid);
    }


    public String Addinterest(Long userid,String interestId) {
        Optional<Users> user=userRepoObj.findById(userid);
        if(user.isPresent()){
            Users users=user.get();
            List<String> list=users.getInterest();



            if (list!=null){
//                System.out.println("True here 1");
                list.add(interestId);
                users.setInterest(list);
                userRepoObj.save(users);

            }
            else {
//                System.out.println("True here 2");
                List<String> list1=new ArrayList<>();
                list1.add(interestId);
                users.setInterest(list1);
//                System.out.println(users.getRegEvents());
                userRepoObj.save(users);
            }
        }
        return "interest added successfully";
    }

    public String AddEvent(Long userid, String event) {
        Optional<Users> user=userRepoObj.findById(userid);
        if(user.isPresent()){
            Users users=user.get();
            List<String> list=users.getRegEvents();
            if (list!=null){
                System.out.println("True here 1");
                list.add(event);
                users.setRegEvents(list);
                userRepoObj.save(users);

            }
            else {
                System.out.println("True here 2");
                List<String> list1=new ArrayList<>();
                list1.add(event);
                users.setRegEvents(list1);
                System.out.println(users.getRegEvents());
                userRepoObj.save(users);
            }
        }
        return "event registered successfully";
    }

    public List<Event> getRegEvents(Long userid) {
        Optional<Users> user=userRepoObj.findById(userid);
        List<Event> events=new ArrayList<>();
        if(user.isPresent()) {
            Users users = user.get();
            List<String> regievents = users.getRegEvents();
            if (regievents != null) {
                for (String i : regievents) {
                    Event event=eventrepoobj.findByName(i);
                    if (event!=null){
                        events.add(event);
                    }
                }
            }
        }
        return events;
    }

    public List<Interest> getInterests(Long userid) {
        Optional<Users>user= userRepoObj.findById((userid));
        List<Interest>interests=new ArrayList<>();
        if(user.isPresent()){
            Users users=user.get();
            List<String>interest=users.getInterest();
            if(interests!=null){
                for(String i: interest){
                    Interest inter=interestRepoObj.findByInterestName(i);
                    if(inter!=null){
                        interests.add(inter);
                    }
                }
            }

        }
        return interests;
    }
}