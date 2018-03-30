package com.jtd.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jtd.entity.Ly;
@Service("LyDaoImpl")
public class LyDaoImpl implements LyDao{

	@Override
	public List<Ly> getLysByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Ly ly) {
		// TODO Auto-generated method stub
		return 0;
	}

}
