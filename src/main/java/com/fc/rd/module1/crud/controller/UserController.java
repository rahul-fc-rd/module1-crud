package com.fc.rd.module1.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.service.UserService;
import com.fc.rd.module1.crud.util.MscException;
import com.fc.rd.module1.crud.util.ResponseBean;
import com.fc.rd.module1.rud.pojo.User;

@RestController
@RequestMapping(value = "/fc")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> createUser(@RequestBody User user) {

		UserEntity savedUserEntity = userService.save(user);
		return new ResponseEntity<>(new ResponseBean(201, "Success", savedUserEntity), HttpStatus.CREATED);

	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> getAll() {
		try {
			List<UserEntity> list = (List<UserEntity>) userService.getAll();
			;
			return new ResponseEntity<>(new ResponseBean(200, "Success", list), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new ResponseBean(500, "fail", ex.getMessage(), null),
					HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> findById(@PathVariable(value = "id") long id) {
		Optional<UserEntity> userEntity = userService.findById(id);
		Object obj = new Object();
		if (userEntity.isPresent()) {
			obj = userEntity.get();
			return new ResponseEntity<>(new ResponseBean(200, "Success", obj), HttpStatus.OK);
		} else {
			throw new MscException("No Record found by this id :", id);
		}
	}

	@PutMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> update(@PathVariable(value = "id") long id, @RequestBody User user) {
		UserEntity updatedUser = userService.update(id, user);
		if (updatedUser != null) {
			return new ResponseEntity<>(new ResponseBean(200, "Success", updatedUser), HttpStatus.OK);
		} else {
			throw new MscException("No Record found by this id :", id);
		}

	}

	@DeleteMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean> deleteById(@PathVariable(value = "id") long id) {
		Optional<UserEntity> userEntityToBeDeleted = userService.delete(id);

		if (userEntityToBeDeleted != null) {
			return new ResponseEntity<>(new ResponseBean(200, "Success", userEntityToBeDeleted.get()), HttpStatus.OK);
		} else {
			throw new MscException("No Record found by this id :", id);

		}
	}
}
