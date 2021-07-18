package com.fc.rd.module1.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fc.rd.module1.crud.config.Constant;
import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.pojo.User;
import com.fc.rd.module1.crud.service.UserService;
import com.fc.rd.module1.crud.util.GenericErrorCode;
import com.fc.rd.module1.crud.util.ResponseBean;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean<UserEntity>> createUser(@RequestBody User user) {

		UserEntity savedUserEntity = userService.save(user);
		return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.CREATED.getCode(),
				GenericErrorCode.CREATED.getDefaultMessage(), savedUserEntity), HttpStatus.CREATED);

	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean<List<UserEntity>>> getAll() {
	
			List<UserEntity> list = (List<UserEntity>) userService.getAll();
			return new ResponseEntity<ResponseBean<List<UserEntity>>>(
					new ResponseBean<List<UserEntity>>(GenericErrorCode.SUCCESS.getCode(),
							GenericErrorCode.SUCCESS.getDefaultMessage(), list),
					HttpStatus.OK);
		}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean<UserEntity>> findById(@PathVariable(value = "id") long id) {
		Optional<UserEntity> userEntity = userService.findById(id);
		UserEntity obj = new UserEntity();
		if (userEntity.isPresent()) {
			obj = userEntity.get();
			return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.SUCCESS.getCode(),
					GenericErrorCode.SUCCESS.getDefaultMessage(), obj), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.ERR_01.getCode(),
					GenericErrorCode.ERR_01.getDefaultMessage(), Constant.NO_RECORD_FOUND_BY_THIS_ID + id, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean<UserEntity>> update(@PathVariable(value = "id") long id,
			@RequestBody User user) {
		UserEntity updatedUser = userService.update(id, user);
		if (updatedUser != null) {
			return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.SUCCESS.getCode(),
					GenericErrorCode.SUCCESS.getDefaultMessage(), updatedUser), HttpStatus.OK);
		} else {
//			throw new MscException("No Record found by this id :", id);
			return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.ERR_01.getCode(),
					GenericErrorCode.ERR_01.getDefaultMessage(), Constant.NO_RECORD_FOUND_BY_THIS_ID + id, null),
					HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseBean<UserEntity>> deleteById(@PathVariable(value = "id") long id) {
		Optional<UserEntity> userEntityToBeDeleted = userService.delete(id);

		if (userEntityToBeDeleted != null) {
			return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.SUCCESS.getCode(),
					GenericErrorCode.SUCCESS.getDefaultMessage(), userEntityToBeDeleted.get()), HttpStatus.OK);
		} else {
//			throw new MscException("No Record found by this id :", id);
			return new ResponseEntity<>(new ResponseBean<UserEntity>(GenericErrorCode.ERR_01.getCode(),
					GenericErrorCode.ERR_01.getDefaultMessage(), Constant.NO_RECORD_FOUND_BY_THIS_ID + id, null),
					HttpStatus.BAD_REQUEST);

		}
	}
}
