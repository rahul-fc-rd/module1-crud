package com.fc.rd.module1.crud.repoInt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fc.rd.module1.crud.entity.UserEntity;

@Repository
public interface UserRepoInt extends CrudRepository<UserEntity, Integer> {

}
