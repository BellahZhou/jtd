package com.jtd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtd.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

	List<UserRole> selectByUserRole(UserRole record);
}