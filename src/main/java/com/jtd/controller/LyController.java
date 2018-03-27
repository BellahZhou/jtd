package com.jtd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.dao.LyDao;
import com.jtd.domain.Ly;
import com.jtd.domain.User;

@Controller
public class LyController {
	@Resource
	private LyDao lyDao;
	
	@RequestMapping("/ly")
	@ResponseBody
	public List<Ly> getLy(HttpSession session) throws Exception{
		User user=(User)session.getAttribute("user");
		List<Ly> lys=new ArrayList<>();
		lys=lyDao.getLysByUserId(user.getId());
		return lys;
	}
	

}
