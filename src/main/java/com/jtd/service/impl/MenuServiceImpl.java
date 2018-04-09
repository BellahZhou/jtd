package com.jtd.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtd.dao.IUserDao;
import com.jtd.dao.MenuDao;
import com.jtd.dto.MenuDto;
import com.jtd.entity.Menu;
import com.jtd.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuDao menuDao;
	@Override
	public List<MenuDto> getMenusByUserId(Long userId, Menu menu) {
		return menuDao.getMenusByUserId(userId, menu);
	}

	@Override
	public List<MenuDto> getMenusAuthorityByUserId(Map<String, Object> map) {
		return menuDao.getMenusAuthorityByUserId( map);
	}

	@Override
	public Menu selectByPrimaryKey(Long menuId) {
		return menuDao.selectByPrimaryKey(menuId);
	}

}
