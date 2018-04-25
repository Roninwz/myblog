package com.zua.blog.dao;

import java.util.List;

import com.zua.blog.entity.User;

public interface UserDao {
	
    public boolean loginUsername(String username, String password);
	public boolean loginEmail(String email, String password);
//	public boolean login(User user);
	public boolean register(User user);
	//查询所有用户
	public List<User> allUser();
	
	//根据用户名查找用户
	public List<User> selectUser(String username);
}
