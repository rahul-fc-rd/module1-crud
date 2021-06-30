package com.fc.rd.module1.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.pojo.User;
import com.fc.rd.module1.crud.repoInt.UserRepoInt;
import com.fc.rd.module1.crud.serviceInt.UserServiceInt;
import com.fc.rd.module1.crud.util.PojoToEntityMapperUtil;

@Service
public class UserService  implements UserServiceInt{

	@Autowired
	private UserRepoInt userRepoInt;
	
	@Override
	public UserEntity save(User user) {
		UserEntity newUserEntity= new UserEntity();
//		BeanUtils.copyProperties(user,userEntity);
		newUserEntity=PojoToEntityMapperUtil.toEntity(user,newUserEntity);
		return userRepoInt.save(newUserEntity);
		
		
	}

	@Override
	public List<UserEntity> getAll(){
		return (List<UserEntity>) userRepoInt.findAll();
	}
	
	@Override
	public Optional<UserEntity> findById(long id) {
		return userRepoInt.findById(id);
	}

	@Override
	public UserEntity update(long id, User user) {
		
		Optional<UserEntity> getUserEntity=userRepoInt.findById(id);
		  if(getUserEntity.isPresent()) {
				UserEntity userEntit = PojoToEntityMapperUtil.toEntity(user,getUserEntity.get());
				return userRepoInt.save(userEntit);
		  }
		  return null;
	}

	@Override
	public Optional<UserEntity> delete(long id) {
		Optional<UserEntity> userEntityToBeDeleted=userRepoInt.findById(id);
		if(userEntityToBeDeleted.isPresent()) {
			  userRepoInt.deleteById(id); 
			  return userEntityToBeDeleted;
		}
		return null;
		
	}
}
