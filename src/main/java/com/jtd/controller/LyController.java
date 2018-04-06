package com.jtd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.dao.LyDao;
import com.jtd.entity.Ly;
import com.jtd.entity.User;
import com.jtd.service.IUserService;
import com.jtd.service.LyService;
import com.jtd.util.SecurityContextUtil;

@Controller
public class LyController {
	@Autowired
	private LyService lyService;
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/ly")
	@ResponseBody
	public List<Ly> getLy(HttpSession session) throws Exception{
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		List<Ly> lys=new ArrayList<>();
		lys=lyService.getLysByUserId(user.getId());
		return lys;
	}
	
	@RequestMapping("/ly/doSubmit")
	@ResponseBody
	public int doSubmit(HttpSession session,@RequestBody Ly ly){
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		ly.setUserId(user.getId());
		ly.setCreateBy(user.getUsername());
		ly.setCreateDate(new Date());
		ly.setUpdateBy(user.getUsername());
		ly.setUpdateDate(new Date());
		int i=lyService.insert(ly);
		if(i==1){
			return i;
		}else{
			return 0;
		}
	}
	

}
