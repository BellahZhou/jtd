package com.jtd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.entity.Fjbf;
import com.jtd.entity.Ly;
import com.jtd.entity.User;
import com.jtd.service.FjbfService;
import com.jtd.service.IUserService;
import com.jtd.util.PropertiesUtil;
import com.jtd.util.SecurityContextUtil;

@Controller
@RequestMapping({"/fjbf"})
public class FjbfController {
	@Autowired
	private FjbfService fjbfService;
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/music")
	@ResponseBody
	public Map<String, Object> getMusic(){
		Map<String, Object> map=new HashMap<>();
		String src=PropertiesUtil.getProperty("audio.src");
		String preloadMessage=PropertiesUtil.getProperty("audio.preloadMessage");
		String playerColor=PropertiesUtil.getProperty("audio.playerColor");
		map.put("src", src);
		map.put("preloadMessage", preloadMessage);
		map.put("playerColor", playerColor);
		
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		Fjbf todayPlan=fjbfService.selectTodayPlan(user.getId());
		map.put("todayPlan", todayPlan);
		return map;
		
	}
	
	@RequestMapping({"/save"})
	@ResponseBody
	public int save(@RequestBody Fjbf fjbf){
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		fjbf.setUserId(user.getId());
		int i=fjbfService.insert(fjbf);
		return i;
	}

}
