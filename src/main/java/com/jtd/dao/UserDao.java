package com.jtd.dao;

import com.jtd.domain.User;

public interface UserDao {
	 public abstract User findByUsername(String username);
}
