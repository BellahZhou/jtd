package com.jtd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtd.dao.LyDao;
import com.jtd.entity.Ly;
import com.jtd.service.LyService;
@Service
public class LyServiceImpl implements LyService{
	@Resource
	private LyDao lyDao;
	
	@Override
	public List<Ly> getLysByUserId(Long userId) {
		return lyDao.getLysByUserId(userId);
	}

	@Override
	public int insert(Ly ly) {
		return lyDao.insert(ly);
	}

	@Override
	public List<Ly> getLs() {
		return lyDao.getLs();
	}

	@Override
	public int update(Ly ly) {
		return lyDao.updateByPrimaryKeySelective(ly);
	}

	@Override
	public Ly selectByProInstIdAndTaskId(String processInstanceId,String taskId) {
		return lyDao.selectByProInstIdAndTaskId(processInstanceId,taskId);
	}

}
