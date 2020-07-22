package com.example.demo;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	UserProfileService service;
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void getAllUser(){
		List<UserProfile> userProfiles = service.getUserProfileList();
		log.info("user list : {}", userProfiles);
	}

	@Test
	void getUserByID(){
		UserProfile userProfile = service.getUserProfile(1).orElseThrow();
		log.info("user list : {}", userProfile);
	}

	@Test
	void validTest() throws Exception {
		ResultActions result = mockMvc.perform(get("/user/all")
					.contentType(MediaType.APPLICATION_JSON));

		result
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void getUserProfile() throws Exception {
		mockMvc.perform(get("/user/{id}",1))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
