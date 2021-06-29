package com.fc.rd.module1.crud.repoInt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fc.rd.module1.crud.entity.UserEntity;

@Repository
public interface UserRepoInt extends JpaRepository<UserEntity, Integer> {

}
