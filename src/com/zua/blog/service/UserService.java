package com.zua.blog.service;

import com.zua.blog.entity.User;

public interface UserService {
	public boolean loginUsername(String username, String password);

	public boolean loginEmail(String email, String password);

	public boolean register(User user);
}
