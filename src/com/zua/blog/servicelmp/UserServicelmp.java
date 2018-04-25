package com.zua.blog.servicelmp;

import com.sun.org.apache.regexp.internal.REUtil;
import com.zua.blog.dao.UserDao;
import com.zua.blog.entity.User;
import com.zua.blog.service.UserService;

public class UserServicelmp implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub

		boolean f = userDao.login(user);

		return f;
		// return user;
	}

	@Override
	public boolean register(User user) {
		boolean flag=false;
		
		flag=userDao.register(user);
		
		
		return flag;
	}

}
