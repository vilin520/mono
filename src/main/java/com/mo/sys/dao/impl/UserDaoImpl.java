package com.mo.sys.dao.impl;

import org.springframework.stereotype.Repository;

import com.mo.common.dao.impl.BaseDaoImpl;
import com.mo.sys.dao.UserDao;
import com.mo.sys.model.User;

@Repository("userDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
