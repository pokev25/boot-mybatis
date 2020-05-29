package com.example.demo.mapper;

import com.example.demo.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserProfileMapper {

    @Select("SELECT * FROM UserProfile where id=#{id}")
    UserProfile getUserProfile(@Param("id") int id);

    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO UserProfile Values(#{id}, #{name}, #{phone}, #{address})")
    int insertUserProfile(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Update("Update UserProfile set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
    int updateUserProfile(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Delete("delete from UserProfile where id=#{id}")
    int deleteUserProfile(@Param("id") int id);
}
