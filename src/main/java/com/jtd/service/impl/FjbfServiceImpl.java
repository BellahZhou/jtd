package com.jtd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtd.dao.FjbfMapper;
import com.jtd.entity.Fjbf;
import com.jtd.service.FjbfService;
@Service
public class FjbfServiceImpl implements FjbfService{
	@Autowired
	private FjbfMapper fjbfDao;
	@Override
	public int insert(Fjbf record) {
		return fjbfDao.insert(record);
	}

}
