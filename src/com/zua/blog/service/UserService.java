package com.zua.blog.service;

import java.util.List;

import com.zua.blog.entity.User;

public interface UserService {
	public boolean loginUsername(String username, String password);

	public boolean loginEmail(String email, String password);

	public boolean register(User user);
	
	//查询所有用户
	public List<User> allUser();
	
	//根据用户名查找用户
		public List<User> selectUser(String username);
		//用于注册时ajax验证用户名或邮箱是否存在
		public boolean isExistUsername(String username);
		public boolean isExistEmail(String email);
}
