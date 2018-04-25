package com.jtd.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jtd.dao.LyDao;
import com.jtd.dto.LyDto;
import com.jtd.entity.Ly;
import com.jtd.entity.User;
import com.jtd.service.LyService;
@Service
public class LyServiceImpl implements LyService{
	@Resource
	private LyDao lyDao;
	@Resource
	private ActivitiService activitiService;
	@Resource
	private LyService lyService;
	
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
	public List<LyDto> selectByProInstId(Map<String, Object> map) {
		return lyDao.selectByProInstId(map);
	}

	@Override
	public List<LyDto> queryTask(Integer pageNum, Integer pageSize, Map<String, Object> map) {
		Object userObject=map.get("user");
		List<Task> tasks=activitiService.queryTask((User)userObject);
		String[] strings=new String[tasks.size()];
		for (int i = 0; i < tasks.size(); i++) {
				strings[i]=tasks.get(i).getProcessInstanceId();
		}
        if (strings != null) {
            map.put("procInstIds", Arrays.asList(strings));
        }
        
        
        PageHelper.startPage(pageNum, pageSize);
        
        return lyService.selectByProInstId(map);
	}

}
