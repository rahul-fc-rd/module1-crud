package com.fc.rd.module1.crud.service;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.rud.pojo.User;


public class PojoToEntityMapperUtil {
	
	public static UserEntity toEntity(User user) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(user.getEmail());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setMiddleName(user.getMiddleName());
		userEntity.setMobile(user.getMobile());
		userEntity.setTelephoneExtension(user.getTelephoneExtension());
		userEntity.setTelephone(user.getTelephone());
		userEntity.setPassword(user.getPassword());
		
		return userEntity;
	}
	

}
