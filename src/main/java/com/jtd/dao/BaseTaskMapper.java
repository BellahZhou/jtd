package com.jtd.dao;

import com.jtd.entity.BaseTask;

public interface BaseTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseTask record);

    int insertSelective(BaseTask record);

    BaseTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseTask record);

    int updateByPrimaryKey(BaseTask record);
}