package com.jtd.dto;

import java.io.Serializable;
import com.jtd.entity.BaseTask;
import com.jtd.entity.Ly;

public class TaskDto extends BaseTask implements Serializable{
	private Ly ly;

	public Ly getLy() {
		return ly;
	}

	public void setLy(Ly ly) {
		this.ly = ly;
	}
	
}
