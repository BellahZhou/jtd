package com.jtd.util;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextUtil
{
  public static com.jtd.entity.User getCurrentUser()
  {
    SecurityContext ctx = SecurityContextHolder.getContext();
    MyUserDetail detail = (MyUserDetail)ctx.getAuthentication().getPrincipal();
    return detail.getUser();
  }
  
  public static String getUsername()
  {
    com.jtd.entity.User user = getCurrentUser();
    if (user == null) {
      return null;
    }
    return user.getUsername();
  }
  
  public static Long getUserId(){
    com.jtd.entity.User user = getCurrentUser();
    if (user == null) {
      return null;
    }
    return user.getId();
  }
  
  public static class MyUserDetail extends org.springframework.security.core.userdetails.User {
    private com.jtd.entity.User user;
    
    public MyUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
      super(password, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
    
    public MyUserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, com.jtd.entity.User user) {
      super(password, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
      this.user = user;
    }
    
    public com.jtd.entity.User getUser() {
      return this.user;
    }
    
    public void setUser(com.jtd.entity.User user) {
      this.user = user;
    }
  }
}
