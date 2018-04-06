package com.jtd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtd.entity.User;

public interface IUserDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User findByUsername(@Param("username")String username);

	List<User> selectByUsernamePassword(@Param("username")String username,@Param("password") String password);
}