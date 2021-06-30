package com.fc.rd.module1.crud.serviceInt;

import java.util.List;
import java.util.Optional;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.pojo.User;


public interface UserServiceInt {

	public UserEntity save(User user);

	public List<UserEntity> getAll();
	
	public Optional<UserEntity> findById(long id);
	
    public UserEntity update(long id,User user);
	
	public Optional<UserEntity> delete(long id);
	
}
