package com.fc.rd.module1.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/all")
	public ResponseEntity<ResponseBean> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<ResponseBean> findById(@PathVariable (value="id")long id) {
		return userService.findById(id);
	}
	
	 @PutMapping("/users/{id}")
	  public ResponseEntity<ResponseBean> update(@PathVariable(value="id") long id,@RequestBody User user) {
			
		 return userService.update(id, user);
		  
	  }
	
	 @DeleteMapping("/users/{id}")
	  public ResponseEntity<ResponseBean> deleteById(@PathVariable(value="id") long id) {
		 
		  return userService.delete(id);
	  }
}
