package com.jtd.service.impl;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtd.entity.User;
@Service
public class ActivitiService {
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;

	public ProcessInstance startFlow() {
	        /** 
	         * 启动请假单流程  并获取流程实例 
	         * 因为该请假单流程可以会启动多个所以每启动一个请假单流程都会在数据库中插入一条新版本的流程数据 
	         * 通过key启动的流程就是当前key下最新版本的流程 
	         *  
	         */  
	        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");  
	        System.out.println("id:"+processInstance.getId()+",activitiId:"+processInstance.getActivityId());
	        return processInstance;
		
	}

	public List<Task> queryTask(User user) {
	    //根据接受人获取该用户的任务  
	    List<Task> tasks = taskService.createTaskQuery()  
	                                .taskAssignee(user.getUsername())  
	                                .list();  
	    for (Task task : tasks) {  
	        System.out.println("ID:"+task.getId()+",姓名:"+task.getName()+",接收人:"+task.getAssignee()+",开始时间:"+task.getCreateTime());  
	    } 
	    return tasks;
	}
	
	public void startTask(String taskId){  
	    //taskId 就是查询任务中的 ID  
	    //完成请假申请任务  
	    taskService.complete(taskId );  
	} 

}
