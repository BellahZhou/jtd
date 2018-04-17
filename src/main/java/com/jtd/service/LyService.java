package com.jtd.service;

import java.util.List;

import com.jtd.entity.Ly;

public interface LyService {
	public List<Ly> getLysByUserId(Long userId);

	public int insert(Ly ly);

	public List<Ly> getLs();

	public int update(Ly ly);

	public Ly selectByProInstIdAndTaskId(String processInstanceId,String taskId);
}
