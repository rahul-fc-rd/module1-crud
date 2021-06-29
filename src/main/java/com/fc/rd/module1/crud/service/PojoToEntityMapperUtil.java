package com.fc.rd.module1.crud.service;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.rud.pojo.User;


public class PojoToEntityMapperUtil {
	
	public static UserEntity toEntity(User user,UserEntity userEntity) {
		
		if(user.getEmail()!=null)
		userEntity.setEmail(user.getEmail());
		if(user.getFirstName()!=null)
		userEntity.setFirstName(user.getFirstName());
		if(user.getLastName()!=null)
		userEntity.setLastName(user.getLastName());
		if(user.getMiddleName()!=null)
		userEntity.setMiddleName(user.getMiddleName());
		if(user.getMobile()!=null)
		userEntity.setMobile(user.getMobile());
		if(user.getTelephoneExtension()!=null)
		userEntity.setTelephoneExtension(user.getTelephoneExtension());
		if(user.getTelephone()!=null)
		userEntity.setTelephone(user.getTelephone());
		if(user.getPassword()!=null)
		userEntity.setPassword(user.getPassword());
		
		return userEntity;
	}
	
}
