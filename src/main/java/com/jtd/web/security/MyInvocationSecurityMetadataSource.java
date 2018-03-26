package com.jtd.web.security;


import java.util.Collection;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    String url = ((FilterInvocation)object).getRequestUrl();
    if (url.contains("?")) {
      url = url.substring(0, url.indexOf("?"));
    }
    return null;
  }
  
  public boolean supports(Class<?> clazz) {
    return true;
  }
  
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }
}
