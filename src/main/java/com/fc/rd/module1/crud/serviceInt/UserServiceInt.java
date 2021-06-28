package com.fc.rd.module1.crud.serviceInt;

import org.springframework.http.ResponseEntity;

import com.fc.rd.module1.crud.util.ResponseBean;
import com.fc.rd.module1.rud.pojo.User;


public interface UserServiceInt {

	ResponseEntity<ResponseBean> save(User user);
	
}
