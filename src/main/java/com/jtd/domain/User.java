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
import org.springframework.security.core.GrantedAuthority;  
import org.springframework.security.core.authority.SimpleGrantedAuthority;  
import org.springframework.security.core.userdetails.UserDetails;  
  
@Table(name = "TB_USER")   
public class User implements UserDetails {  
      
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
      
    /** 
     * Returns the authorites string 
     *  
     * eg.  
     *    downpour --- ROLE_ADMIN,ROLE_USER 
     *    robbin --- ROLE_ADMIN 
     *  
     * @return 
     */  
    public String getAuthoritiesString() {  
        List<String> authorities = new ArrayList<String>();  
        for(GrantedAuthority authority : this.getAuthorities()) {  
            authorities.add(authority.getAuthority());  
        }  
        return StringUtils.join(authorities, ",");  
    }  
  
    @Override  
    public Collection<? extends GrantedAuthority> getAuthorities() {  
        // 根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过  
        if(!roles.isEmpty()){  
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();  
            GrantedAuthority au = new SimpleGrantedAuthority("ROLE_USER");  
            list.add(au);  
            return list;  
        }  
        return null;  
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
  
    /** 
     * @return the roleResources 
     */  
    public Map<String, List<Resource>> getRoleResources() {  
        // init roleResources for the first time  
        System.out.println("---------------------------------------------------");  
        if(this.roleResources == null) {  
              
            this.roleResources = new HashMap<String, List<Resource>>();  
              
            for(Role role : this.roles) {  
                String roleName = role.getRoleName();  
                Set<Resource> resources = role.getResources();  
                for(Resource resource : resources) {  
                    String key = roleName + "_" + resource.getType();  
                    if(!this.roleResources.containsKey(key)) {  
                        this.roleResources.put(key, new ArrayList<Resource>());  
                    }  
                    this.roleResources.get(key).add(resource);                    
                }  
            }  
              
        }  
        return this.roleResources;  
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
