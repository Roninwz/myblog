package com.zua.blog.dao;

import com.zua.blog.entity.User;

public interface UserDao {
/*	public boolean loginUsername(String username, String password);
	public boolean loginEmail(String email, String password);*/
	public boolean login(User user);
	public boolean register(User user);
}
