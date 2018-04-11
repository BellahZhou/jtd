package com.jtd.service.impl;

import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtd.dao.UserAttendsMapper;
import com.jtd.dao.UserRoleMapper;
import com.jtd.entity.User;
import com.jtd.entity.UserAttends;
import com.jtd.entity.UserRole;
import com.jtd.service.UserAttendsService;
@Service
public class UserAttendsServiceImpl implements UserAttendsService{
	@Autowired
	private UserAttendsMapper userAttendsMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
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
	@Override
	public void upgrade() {
		List<UserAttends> users=userAttendsMapper.getAttendsForVIP();
		for (UserAttends userAttends : users) {
			if(userAttends.getUserId()!=1){
				UserRole userRole=new UserRole();
				userRole.setUserId(userAttends.getUserId());
				userRole.setRoleId((long)3);
				List<UserRole> userRoles=userRoleMapper.selectByUserRole(userRole);
				if(userRoles.size()<1){
					userRole.setCreateBy("admin");
					userRole.setCreateDate(new Date());
					userRole.setUpdateBy("admin");
					userRole.setUpdateDate(new Date());
					userRoleMapper.insert(userRole);
				}
			}
		}
	}

}
