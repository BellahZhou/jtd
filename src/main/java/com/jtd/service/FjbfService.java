package com.jtd.service;
import com.jtd.entity.Fjbf;

public interface FjbfService {
	int insert(Fjbf record);

	Fjbf selectTodayPlan(Long userId);

	int updateByPrimaryKey(Fjbf fjbf);
	
}
