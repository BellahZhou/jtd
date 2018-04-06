package com.jtd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jtd.dao.IUserDao;
import com.jtd.dao.MenuDao;
import com.jtd.dto.MenuDto;
import com.jtd.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuDao menuDao;
	@Override
	public List<MenuDto> getMenusByUserId(Long userId, Integer menu) {
		return menuDao.getMenusByUserId(userId, menu);
	}

	@Override
	public List<MenuDto> getMenusAuthorityByUserId(Long id, Long menuId) {
		return menuDao.getMenusAuthorityByUserId(id, menuId);
	}

}
