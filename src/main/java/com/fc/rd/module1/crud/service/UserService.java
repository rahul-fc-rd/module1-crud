package com.fc.rd.module1.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.repoInt.UserRepoInt;
import com.fc.rd.module1.crud.serviceInt.UserServiceInt;
import com.fc.rd.module1.crud.util.ResponseBean;
import com.fc.rd.module1.rud.pojo.User;

@Service
public class UserService  implements UserServiceInt{

	@Autowired
	private UserRepoInt userRepoInt;
	
	@Override
	public ResponseEntity<ResponseBean> save(User user) {
		
//		UserEntity userEntity = new UserEntity();
//		BeanUtils.copyProperties(user,userEntity);
		UserEntity userEntity=PojoToEntityMapperUtil.toEntity(user);
		
		UserEntity savedUser = userRepoInt.save(userEntity);
		
		return new ResponseEntity<>(new ResponseBean(201,"Success",savedUser),HttpStatus.CREATED);
	}

	
}
