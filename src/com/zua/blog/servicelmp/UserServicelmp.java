package com.zua.blog.servicelmp;

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

	/*@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub

		boolean f = userDao.login(user);

		return f;
		// return user;
	}
*/
	@Override
	public boolean register(User user) {
		boolean flag=false;
		
		flag=userDao.register(user);
		
		
		return flag;
	}

	@Override
	public boolean loginUsername(String username, String password) {
		boolean f = userDao.loginUsername(username, password);

		return f;
	}

	@Override
	public boolean loginEmail(String email, String password) {
		boolean f = userDao.loginEmail(email, password);
		return f;
	}

}
