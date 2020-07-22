package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProfileController {

    UserProfileService service;

    public UserProfileController(UserProfileService service){
        this.service = service;
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") int id){
        return service.getUserProfile(id).orElse(null);
    }

//    @GetMapping("/user/{id}")
//    public UserProfile getUserProfile(@PathVariable("id") UserProfile user){
//        return user;
//    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList(){
        return service.getUserProfileList();
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
        service.insertUserProfile(id,name,phone,address);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
        service.updateUserProfile(id,name,phone,address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") int id){
        service.deleteUserProfile(id);
    }
}
