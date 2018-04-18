package com.jtd.dto;

import java.util.Date;

import com.jtd.entity.Ly;

public class LyDto extends Ly{
	
	private String taskName;
	private String assingee;
	private Date taskCreateTime;
	
	
	public Date getTaskCreateTime() {
		return taskCreateTime;
	}
	public void setTaskCreateTime(Date taskCreateTime) {
		this.taskCreateTime = taskCreateTime;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getAssingee() {
		return assingee;
	}
	public void setAssingee(String assingee) {
		this.assingee = assingee;
	}
	

}
