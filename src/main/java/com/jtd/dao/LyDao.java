package com.jtd.dao;

import java.util.List;

import com.jtd.domain.Ly;

public interface LyDao {
	public abstract List<Ly> getLysByUserId(Long userId);

	public abstract int insert(Ly ly);
}
