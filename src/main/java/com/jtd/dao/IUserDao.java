package com.jtd.dao;

import java.util.List;
import com.jtd.entity.User;

public interface IUserDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> selectByUsernamePassword(String userName, String password);
}