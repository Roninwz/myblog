package com.zua.blog.dao;

import com.zua.blog.entity.User;

public interface UserDao {
	//用于用户名和邮箱都能登录
    public boolean loginUsername(String username, String password);
	public boolean loginEmail(String email, String password);
//	public boolean login(User user);
	public boolean register(User user);
}
