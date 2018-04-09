package com.jtd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jtd.dto.MenuDto;
import com.jtd.entity.Menu;

public interface MenuService {
	public List<MenuDto> getMenusByUserId(Long userId,Menu menu);

	public List<MenuDto> getMenusAuthorityByUserId(Map<String, Object> map);

	public Menu selectByPrimaryKey(Long menuId);
}
