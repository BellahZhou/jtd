package com.jtd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.jtd.entity.Ly;
public interface LyDao {
	public abstract List<Ly> getLysByUserId(Long userId);

	public abstract int insert(Ly ly);

	public abstract List<Ly> getLs();
	
	int updateByPrimaryKeySelective(Ly record);

	public abstract Ly selectByProInstIdAndTaskId(@Param("processInstanceId") String processInstanceId,@Param("taskId") String taskId);
}
