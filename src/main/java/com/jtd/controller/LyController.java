package com.jtd.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jtd.dto.LyDto;
import com.jtd.dto.TaskDto;
import com.jtd.entity.BaseTask;
import com.jtd.entity.Ly;
import com.jtd.entity.User;
import com.jtd.service.IUserService;
import com.jtd.service.LyService;
import com.jtd.service.impl.ActivitiService;
import com.jtd.util.SecurityContextUtil;

@Controller
@RequestMapping("/ly")
public class LyController {
	@Autowired
	private LyService lyService;
	@Resource(name="userService")
	private IUserService userService;
	@Autowired
	private ActivitiService activitiService;
	
	@RequestMapping(value = "/myTask",method = RequestMethod.POST)
	@ResponseBody
	public PageInfo<?> getmyTask(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user", user);
		List<LyDto> taskDtos=lyService.queryTask(pageNum, pageSize,map);
	
		PageInfo<?> pageInfo = new PageInfo<LyDto>(taskDtos);
		return pageInfo;
	}
	

	@RequestMapping("/myLyDetail")
	@ResponseBody
	public List<Ly> getLy(HttpSession session) throws Exception{
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		List<Ly> lys=new ArrayList<>();
		lys=lyService.getLysByUserId(user.getId());
		return lys;
	}
	
	@RequestMapping(value = "/history",method = RequestMethod.POST)
	@ResponseBody
	public List<Ly> getLs(HttpSession session) throws Exception{
		return lyService.getLs();
	}
	
	@RequestMapping("/doSubmit")
	@ResponseBody
	public int doSubmit(HttpSession session,@RequestBody Ly ly){
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		ly.setUserId(user.getId());
		ly.setCreateBy(user.getUsername());
		ly.setCreateDate(new Date());
		ly.setUpdateBy(user.getUsername());
		ly.setUpdateDate(new Date());
		
		ProcessInstance processInstance=activitiService.startFlow();
		ly.setProcInstId(processInstance.getProcessInstanceId());
		int i=lyService.insert(ly);
		
		if(i==1){
			return i;
		}else{
			return 0;
		}
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public int update(@RequestBody Ly ly) throws Exception{
		return lyService.update(ly);
	}
	

	@RequestMapping("/completeTask")
	@ResponseBody
	public void completeTask(@RequestParam(value="taskId") String taskId){
		activitiService.startTask(taskId);
	}
}
