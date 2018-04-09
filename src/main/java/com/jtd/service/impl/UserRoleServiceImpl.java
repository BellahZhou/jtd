package com.jtd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtd.dao.UserRoleMapper;
import com.jtd.entity.UserRole;
import com.jtd.service.UserRoleService;
@Service
public class UserRoleServiceImpl  implements UserRoleService{
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Override
	public int insert(UserRole ur) {
		return userRoleMapper.insert(ur);
	}

}
