package com.jtd.service;

import java.util.List;

import com.jtd.dto.MenuDto;

public interface MenuService {
	public List<MenuDto> getMenusByUserId(Long userId,Integer menu);

	public List<MenuDto> getMenusAuthorityByUserId(Long id, Long menuId);
}
