package com.jtd.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jtd.util.PropertiesUtil;

@Controller
@RequestMapping("/ywdh")
public class YwdhController {
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> getList(){
		Map<String, Object> map=new HashMap<>();
		String phone=PropertiesUtil.getProperty("my.phone");
		String email=PropertiesUtil.getProperty("my.email");
		String address=PropertiesUtil.getProperty("my.address");
		map.put("phone", phone);
		map.put("email", email);
		map.put("address", address);
		return map;
	}
	

}
