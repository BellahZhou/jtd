package com.jtd.entity;

import java.io.Serializable;

public class Role extends IDE implements Serializable{
	private Long id;
	private String roleName;
	private String roleCode;
	private String roleDesc;
	private String roleType;
	private String canDelete;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getCanDelete() {
		return canDelete;
	}
	public void setCanDelete(String canDelete) {
		this.canDelete = canDelete;
	}
	
	

}
