package com.jtd.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.jtd.dto.LyDto;
import com.jtd.entity.Ly;

public interface LyDao {
	public abstract List<Ly> getLysByUserId(Long userId);

	public abstract int insert(Ly ly);

	public abstract List<Ly> getLs();
	
	int updateByPrimaryKeySelective(Ly record);

	public List<LyDto> selectByProInstId(Map<String, Object> map);
}
