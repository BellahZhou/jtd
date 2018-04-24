package com.jtd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jtd.entity.Entry;

public interface EntryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Entry record);

    int insertSelective(Entry record);

    Entry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Entry record);

    int updateByPrimaryKeyWithBLOBs(Entry record);

    int updateByPrimaryKey(Entry record);
    
    List<Entry> getEntry0(String dictTypeId);

    Entry getEntrySingle(@Param("dictTypeId") String dictTypeId, @Param("dictId") String dictId);

	Entry selectOne(@Param("dictEntry") Entry dictEntry);
}