package com.jtd.service;

import com.jtd.entity.User;
import com.jtd.entity.UserAttends;

public interface UserAttendsService {

	UserAttends selectByUser(User user);

	int insert(UserAttends uAttends);

	int update(UserAttends userAttends);

	void upgrade();

}
