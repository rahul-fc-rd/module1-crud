package com.fc.rd.module1.crud.controller.integrationTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.pojo.User;
import com.fc.rd.module1.crud.util.ResponseBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	void testCreateUser() {
		User user = new User("rahul", "12345", "rahul", "kumar", "zzzzzzzz", "885895", "58522", "8888888tt",
				"rshg@djh.com");
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		HttpEntity<User> req = new HttpEntity<>(user,header);
		ResponseEntity<ResponseBean<UserEntity>> response =testRestTemplate.exchange("/users" , HttpMethod.POST,req, new ParameterizedTypeReference<ResponseBean<UserEntity>>() {});
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	}
}
