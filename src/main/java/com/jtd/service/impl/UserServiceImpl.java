package com.jtd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtd.dao.IUserDao;
import com.jtd.entity.User;
import com.jtd.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> selectByUsernamePassword(String userName, String password) {
		return this.userDao.selectByUsernamePassword(userName,password);
	}

}
