package com.zua.blog.service;

import com.zua.blog.entity.User;

public interface UserService {
	public boolean login(User user);

	public boolean register(User user);
}
