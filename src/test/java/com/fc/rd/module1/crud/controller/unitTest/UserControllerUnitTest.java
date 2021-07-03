package com.fc.rd.module1.crud.controller.unitTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import com.fc.rd.module1.crud.service.UserService;
import com.fc.rd.module1.crud.util.ResponseBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerUnitTest {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@MockBean
	UserService userService;
	
	@Mock
	User usr;
	
	@Mock
	UserEntity userEntity;
	
	
	@Test
	void testCreateUserPositive() {
		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		HttpEntity<User> req = new HttpEntity<>(usr,header);
		when(userService.save(usr)).thenReturn(new UserEntity());	
		
		ResponseEntity<ResponseBean<UserEntity>> response =testRestTemplate.exchange("/users" , HttpMethod.POST,req, new ParameterizedTypeReference<ResponseBean<UserEntity>>() {});
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	}
	@Test
	void testgetAllPositive() {
		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		when(userService.getAll()).thenReturn(new ArrayList<UserEntity>());	
		
		ResponseEntity<ResponseBean<List<UserEntity>>> response =testRestTemplate.exchange("/users" , HttpMethod.GET,null, new ParameterizedTypeReference<ResponseBean<List<UserEntity>>>() {});
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	void testfindByIdPositive() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 1l);

		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		HttpEntity<User> req = new HttpEntity<>(header);
		userEntity = new UserEntity();
		userEntity.setEmail("t@gmail.com");
		userEntity.setId(1);
		when(userService.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(userEntity));	
		
		ResponseEntity<ResponseBean<UserEntity>> response =testRestTemplate.exchange("/users/{id}" ,HttpMethod.GET,req, new ParameterizedTypeReference<ResponseBean<UserEntity>>() {},params);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	@Test
	void testfindByIdNegativeIfIdNotPresent() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 1l);

		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		HttpEntity<User> req = new HttpEntity<>(header);
		when(userService.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(null));	
		
		ResponseEntity<ResponseBean<UserEntity>> response =testRestTemplate.exchange("/users/{id}" ,HttpMethod.GET,req, new ParameterizedTypeReference<ResponseBean<UserEntity>>() {},params);
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
	
	@Test
	void testUpdatePositive() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 1l);

		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		usr = new User();
		usr.setEmail("ttt@gmail.com");
		HttpEntity<User> req = new HttpEntity<>(usr,header);
		when(userService.update(Mockito.anyLong(),Mockito.any())).thenReturn(new UserEntity());	
		
		ResponseEntity<ResponseBean<UserEntity>> response =testRestTemplate.exchange("/users/{id}" ,HttpMethod.PUT,req, new ParameterizedTypeReference<ResponseBean<UserEntity>>() {},params);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	
	@Test
	void testUpdateNegativeIfIdNotPresent() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 1l);

		
		HttpHeaders header = new HttpHeaders();
		header.set("content-type", MediaType.APPLICATION_JSON.toString());
		usr = new User();
		usr.setEmail("ttt@gmail.com");
		HttpEntity<User> req = new HttpEntity<>(usr,header);
		when(userService.update(Mockito.anyLong(),Mockito.any())).thenReturn(null);	
		
		ResponseEntity<ResponseBean<UserEntity>> response =testRestTemplate.exchange("/users/{id}" ,HttpMethod.PUT,req, new ParameterizedTypeReference<ResponseBean<UserEntity>>() {},params);
		
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
}
