package com.jtd.dao;

import java.util.List;

import com.jtd.entity.User;
import com.jtd.entity.UserAttends;

public interface UserAttendsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAttends record);

    int insertSelective(UserAttends record);

    UserAttends selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAttends record);

    int updateByPrimaryKey(UserAttends record);

	UserAttends selectByUser(UserAttends userAttends);

	List<UserAttends> getAttendsForVIP();
}