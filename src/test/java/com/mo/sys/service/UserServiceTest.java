package com.mo.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mo.sys.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	
	@Test
	public void testSave(){
		User user = new User();
		user.setLoginName("loginName");
		user.setPassword("password");
		userService.create(user);
	}
	
}
