package com.jtd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.util.PropertiesUtil;

@Controller
public class FjbfController {
	
	@RequestMapping("/fjbf")
	@ResponseBody
	public Map<String, Object> getMusic(){
		Map<String, Object> map=new HashMap<>();
		String src=PropertiesUtil.getProperty("audio.src");
		String preloadMessage=PropertiesUtil.getProperty("audio.preloadMessage");
		String playerColor=PropertiesUtil.getProperty("audio.playerColor");
		map.put("src", src);
		map.put("preloadMessage", preloadMessage);
		map.put("playerColor", playerColor);
		return map;
		
	}

}
