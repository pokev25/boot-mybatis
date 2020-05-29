package com.example.demo.service;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
    private UserProfileMapper mapper;

    public UserProfileService(UserProfileMapper mapper){
        this.mapper = mapper;
    }

    public UserProfile getUserProfile(int id){
        return mapper.getUserProfile(id);
    }

    public List<UserProfile> getUserProfileList(){
        return mapper.getUserProfileList();
    }

    public int insertUserProfile(int id, String name, String phone, String address){
        return mapper.insertUserProfile(id,name,phone,address);
    }

    public int updateUserProfile(int id, String name, String phone, String address){
        return mapper.updateUserProfile(id,name,phone,address);
    }

    public int deleteUserProfile(int id){
        return mapper.deleteUserProfile(id);
    }
}
