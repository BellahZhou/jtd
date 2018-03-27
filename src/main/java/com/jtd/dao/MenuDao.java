package com.jtd.dao;

import java.util.List;

import com.jtd.dto.MenuDto;
import com.jtd.domain.Menu;

public interface MenuDao{
	public abstract List<MenuDto> getMenusByUserId(Long userId,Integer menu);

	public abstract List<MenuDto> getMenusAuthorityByUserId(Long id, Long menuId);
}
