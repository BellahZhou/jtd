package com.jtd.web.security;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {
  public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)throws AccessDeniedException, InsufficientAuthenticationException{
    if (configAttributes == null) {
      return;
    }
    Iterator<ConfigAttribute> ite = configAttributes.iterator();
    String needRole;
    while (ite.hasNext()){
      ConfigAttribute ca = (ConfigAttribute)ite.next();
      needRole = ca.getAttribute();
      for (GrantedAuthority ga : authentication.getAuthorities()) {
        if (needRole.equals(ga.getAuthority())) {
          return;
        }
      }
    }
    throw new AccessDeniedException("没有权限");
  }
  
  public boolean supports(ConfigAttribute attribute){
    return true;
  }
  
  public boolean supports(Class<?> clazz){
    return true;
  }
}

