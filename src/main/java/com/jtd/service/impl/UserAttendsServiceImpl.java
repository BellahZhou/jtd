package com.jtd.service.impl;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtd.dao.UserAttendsMapper;
import com.jtd.entity.User;
import com.jtd.entity.UserAttends;
import com.jtd.service.UserAttendsService;
@Service
public class UserAttendsServiceImpl implements UserAttendsService{
	@Autowired
	private UserAttendsMapper userAttendsMapper;
	@Override
	public UserAttends selectByUser(User user) {
		UserAttends userAttends=new UserAttends();
		userAttends.setUserId(user.getId());
		userAttends.setUserName(user.getUsername());
		return userAttendsMapper.selectByUser(userAttends);
	}
	@Override
	public int insert(UserAttends uAttends) {
		return userAttendsMapper.insert(uAttends);
	}
	@Override
	public int update(UserAttends userAttends) {
		return userAttendsMapper.updateByPrimaryKeySelective(userAttends);
	}

}
