package com.jtd.service;

import java.util.List;
import java.util.Map;

import com.jtd.dto.LyDto;
import com.jtd.entity.Ly;

public interface LyService {
	public List<Ly> getLysByUserId(Long userId);

	public int insert(Ly ly);

	public List<Ly> getLs();

	public int update(Ly ly);

	public List<LyDto> selectByProInstId(Map<String, Object> map);

	public List<LyDto> queryTask(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
