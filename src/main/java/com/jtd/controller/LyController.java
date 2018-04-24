package com.jtd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public List<LyDto> getmyTask(){
		List<LyDto> taskDtos=new ArrayList<LyDto>();
		User user=userService.findByUsername(SecurityContextUtil.getCurrentUser());
		List<Task> tasks=activitiService.queryTask(user);
		for (Task task : tasks) { 
			 LyDto lyDto=new LyDto();
			 Ly ly=lyService.selectByProInstIdAndTaskId(task.getProcessInstanceId());
			 lyDto.setId(ly.getId());
			 lyDto.setRemark(ly.getRemark());
			 lyDto.setTaskId(task.getId());
			 lyDto.setTaskName(task.getName());
			 lyDto.setAssingee(task.getAssignee());
			 lyDto.setTaskCreateTime(task.getCreateTime());
		     System.out.println("ID:"+task.getId()+",姓名:"+task.getName()+",接收人:"+task.getAssignee()+",开始时间:"+task.getCreateTime());  
		     taskDtos.add(lyDto);
		     
		} 
		return taskDtos;
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
