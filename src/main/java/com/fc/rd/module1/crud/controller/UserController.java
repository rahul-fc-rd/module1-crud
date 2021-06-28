package com.fc.rd.module1.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.rd.module1.crud.service.UserService;
import com.fc.rd.module1.crud.util.ResponseBean;
import com.fc.rd.module1.rud.pojo.User;

@RestController
@RequestMapping(value = "/fc")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<ResponseBean> createUser(@RequestBody User user) {
		
		 return userService.save(user);
	}
	
}
