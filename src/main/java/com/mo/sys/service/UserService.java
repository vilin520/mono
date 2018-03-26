package com.mo.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mo.common.dao.BaseDao;
import com.mo.common.service.BaseService;
import com.mo.sys.dao.UserDao;
import com.mo.sys.model.User;


@Service("userService")
public class UserService extends BaseService<User> {

	@Autowired
	private UserDao userDaoImpl;
	
	@Override
	public BaseDao<User> getBaseDao() {
		return userDaoImpl;
	}
	
}
