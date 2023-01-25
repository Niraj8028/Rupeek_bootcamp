package com.example.demo3.Service;

import com.example.demo3.DAO.UserRepo;
import com.example.demo3.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepo userRepoObj;
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
            list.add(interestId);
            users.setInterest(list);
            userRepoObj.save(users);
        }
        return "interest added successfully";
    }
}