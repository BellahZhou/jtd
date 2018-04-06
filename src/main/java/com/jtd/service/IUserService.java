package com.jtd.service;

import java.util.List;

import com.jtd.entity.User;

public interface IUserService {
	public User getUserById(int userId);
	public List<User> selectByUsernamePassword(String username,String password);
	public User findByUsername(String username);
}
