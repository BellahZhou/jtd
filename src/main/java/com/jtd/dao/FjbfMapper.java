package com.jtd.dao;

import com.jtd.entity.Fjbf;

public interface FjbfMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Fjbf record);

    int insertSelective(Fjbf record);

    Fjbf selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Fjbf record);

    int updateByPrimaryKey(Fjbf record);
}