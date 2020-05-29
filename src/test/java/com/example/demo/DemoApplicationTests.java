package com.example.demo;

import com.example.demo.controller.UserProfileController;
import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserProfileService service;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllUser(){
		List<UserProfile> userProfiles = service.getUserProfileList();
		log.info("user list : {}", userProfiles);
	}
}
