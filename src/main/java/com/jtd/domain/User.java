package com.jtd.domain;

import java.util.ArrayList;  
import java.util.Collection;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;  
  
@Table(name = "TB_USER")   
public class User {  
      
    private static final long serialVersionUID = 8026813053768023527L;  
    @Id
    @Column(name = "ID")
    private Long id; 
    @Column(name = "ACCOUNT")
    private String account;  
    @Column(name = "USERNAME")  
    private String username;  
    @Column(name = "PASSWORD")  
    private String password;  
    @Column(name = "DISABLED")  
    private boolean disabled;  
    @Transient
    private Set<Role> roles;  
      
    @Transient
    private Map<String, List<Resource>> roleResources;  
      
    /** 
     * The default constructor 
     */  
    public User() {  
          
    }  
      
    /*  
     * 密码 
     */  
    public String getPassword() {  
        return password;  
    }  
  
  
    /*  
     *帐号是否不过期，false则验证不通过 
     */  
    public boolean isAccountNonExpired() {  
        return true;  
    }  
  
    /*  
     * 帐号是否不锁定，false则验证不通过 
     */  
    public boolean isAccountNonLocked() {  
        return true;  
    }  
  
    /*  
     * 凭证是否不过期，false则验证不通过 
     */  
    public boolean isCredentialsNonExpired() {  
        return true;  
    }  
  
    /*  
     * 该帐号是否启用，false则验证不通过 
     */  
    public boolean isEnabled() {  
        return !disabled;  
    }  
  
  
    /** 
     * @return the disabled 
     */  
    public boolean isDisabled() {  
        return disabled;  
    }  
  
    /** 
     * @return the roles 
     */  
    public Set<Role> getRoles() {  
        return roles;  
    }  
  
  
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/** 
     * @param password the password to set 
     */  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    /** 
     * @param disabled the disabled to set 
     */  
    public void setDisabled(boolean disabled) {  
        this.disabled = disabled;  
    }  
  
    /** 
     * @param roles the roles to set 
     */  
    public void setRoles(Set<Role> roles) {  
        this.roles = roles;  
    }  
  
    public String getAccount() {  
        return account;  
    }  
  
    public void setAccount(String account) {  
        this.account = account;  
    }  
  
    public void setRoleResources(Map<String, List<Resource>> roleResources) {  
        this.roleResources = roleResources;  
    }  
      
}  
