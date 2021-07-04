package com.fc.rd.module1.crud.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fc.rd.module1.crud.entity.UserEntity;
import com.fc.rd.module1.crud.pojo.User;
import com.fc.rd.module1.crud.repoInt.UserRepoInt;
import com.fc.rd.module1.crud.service.UserService;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	UserRepoInt userRepoInt;

	@InjectMocks
	UserService userService;
	
	@Mock
	User newUser;
	@Mock
	UserEntity userEntity;


	@Test
	public void saveTest() {
		userEntity = new UserEntity(1, "rahul", "Welcome@123", "rahul", null, "Kumar", null, null,
				"852892380", "rahul@gmail.com");
		Mockito.when(userRepoInt.save(Mockito.any())).thenReturn(userEntity);
		
		UserEntity savedUser = userService.save(newUser);
		assertEquals("Equals", savedUser, userEntity);
	}
}
