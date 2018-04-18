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
	         * ������ٵ�����  ����ȡ����ʵ�� 
	         * ��Ϊ����ٵ����̿��Ի������������ÿ����һ����ٵ����̶��������ݿ��в���һ���°汾���������� 
	         * ͨ��key���������̾��ǵ�ǰkey�����°汾������ 
	         *  
	         */  
	        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");  
	        System.out.println("id:"+processInstance.getId()+",activitiId:"+processInstance.getActivityId());
	        return processInstance;
		
	}

	public List<Task> queryTask(User user) {
	    //���ݽ����˻�ȡ���û�������  
	    List<Task> tasks = taskService.createTaskQuery()  
	                                .taskAssignee(user.getUsername())  
	                                .list();  
	    for (Task task : tasks) {  
	        System.out.println("ID:"+task.getId()+",����:"+task.getName()+",������:"+task.getAssignee()+",��ʼʱ��:"+task.getCreateTime());  
	    } 
	    return tasks;
	}
	
	public void startTask(String taskId){  
	    //taskId ���ǲ�ѯ�����е� ID  
	    //��������������  
	    taskService.complete(taskId );  
	} 

}
