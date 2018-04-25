package com.jtd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
@Table(name = "tb_ly")
public class Ly extends IDE{
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="PROC_INST_ID")
	private String procInstId;
	@Column(name="USER_ID")
	private Long userId;
	@Column(name="REMARK")
	private String remark;
	@Column(name="REBACK")
	private String reback;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
  public void setProcInstId(String procInstId)
  {
    this.procInstId = procInstId;
  }
  
  public String getProcInstId()
  {
    return this.procInstId;
  }
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReback() {
		return reback;
	}
	public void setReback(String reback) {
		this.reback = reback;
	}

}
