package com.jtd.web.security;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.HashSet;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
  
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;  
import com.jtd.domain.*;
  
  
public class SecurityManagerSupport  implements UserDetailsService{  
    private   Log   log   = LogFactory.getLog(this.getClass().getName());   
       
  
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {  
//        List<User> users = getHibernateTemplate().find("FROM User user WHERE user.name = ? AND user.disabled = false", userName);  
        log.info("SecurityManagerSupport.loadUserByUsername.userName:"+userName);  
          
        User user =null;  
        if("admin".equals(userName)){         
            Set<Role> roles = new HashSet<Role>() ;  
            Role role = new Role();  
            role.setRoleCode("ROLE_USER");  
            role.setRoleName("ROLE_USER");  
              
            Set<Resource> resources=new HashSet<Resource>() ;  
              
            Resource res = new Resource();  
//            res.setResid("ME001");  
//            res.setResName("首页");  
//            res.setResUrl("/jsp/index/main.jsp");  
            res.setType("ROLE_USER");  
            res.setRoles(roles);  
            resources.add(res);  
              
            role.setResources(resources);  
              
            roles.add(role);  
            user = new User();  
            user.setAccount("admin");  
            user.setDisabled(false);  
            user.setPassword("00000000");  
            log.info(user.getPassword());  
            user.setRoles(roles);             
        }  
      return user;//返回UserDetails的实现user不为空，则验证通过  
    }  
      
}  

