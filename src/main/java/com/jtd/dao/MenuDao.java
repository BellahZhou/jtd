package com.jtd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jtd.dto.MenuDto;
import com.jtd.entity.Menu;

public interface MenuDao{
	Menu selectByPrimaryKey(Long id);
	
	public abstract List<MenuDto> getMenusByUserId(@Param("userId") Long userId,@Param("menu")Menu menu);

	public abstract List<MenuDto> getMenusAuthorityByUserId(Map<String, Object> map);
}
