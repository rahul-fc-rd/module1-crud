package com.fc.rd.module1.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.repoInt.UserRepoInt;
import com.fc.rd.module1.crud.serviceInt.UserServiceInt;
import com.fc.rd.module1.crud.util.MscException;
import com.fc.rd.module1.crud.util.ResponseBean;
import com.fc.rd.module1.rud.pojo.User;

@Service
public class UserService  implements UserServiceInt{

	@Autowired
	private UserRepoInt userRepoInt;
	
	@Override
	public ResponseEntity<ResponseBean> save(User user) {
		
		UserEntity userEn = new UserEntity();
//		BeanUtils.copyProperties(user,userEntity);
		UserEntity userEntity=PojoToEntityMapperUtil.toEntity(user,userEn);
		
		UserEntity savedUser = userRepoInt.save(userEntity);
		
		return new ResponseEntity<>(new ResponseBean(201,"Success",savedUser),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseBean> getAll(){
		try {
			List<UserEntity> list = (List<UserEntity>) userRepoInt.findAll();
			return new ResponseEntity<>(new ResponseBean(200,"Success",list),HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(new ResponseBean(500,"fail",ex.getMessage(),null),HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@Override
	public ResponseEntity<ResponseBean> findById(long id) {
		Optional<UserEntity> userEntity = userRepoInt.findById(id);
		Object obj = new Object();
		if(userEntity.isPresent()) {
			obj = userEntity.get();
			return new ResponseEntity<>(new ResponseBean(200,"Success",obj),HttpStatus.OK);
		}else {
			throw new MscException("No Record found by this id :",id);
		
		}
	}

	@Override
	public ResponseEntity<ResponseBean> update(long id, User user) {
		
		  Optional<UserEntity> userEntity = userRepoInt.findById(id);
		  if(userEntity.isPresent()) {
				UserEntity userEntit = PojoToEntityMapperUtil.toEntity(user,userEntity.get());
				UserEntity updatedUser = userRepoInt.save(userEntit);
		  return new ResponseEntity<>(new ResponseBean(200,"Success",updatedUser),HttpStatus.OK); } 
		  else
		  { 
			  throw new MscException("No Record found by this id :",id);
		  
		  }
		 
	}

	@Override
	public ResponseEntity<ResponseBean> delete(long id) {
		Optional<UserEntity> userEntity = userRepoInt.findById(id);
		  if(userEntity.isPresent()) {
			  userRepoInt.deleteById(id);
			  return new ResponseEntity<>(new ResponseBean(200,"Success",userEntity.get()),HttpStatus.OK); } 
		  else
		  { 
			  throw new MscException("No Record found by this id :",id);
		  
		  }
	}
	
		
}
