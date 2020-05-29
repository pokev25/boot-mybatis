package com.example.demo.mapper;

import com.example.demo.model.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    UserProfile getUserProfile(@Param("id") int id);

    List<UserProfile> getUserProfileList();

    int insertUserProfile(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    int updateUserProfile(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    int deleteUserProfile(@Param("id") int id);
}
