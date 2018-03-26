package com.jtd.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class MyLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
  public static final String QUERY_STRING_KEY = "_QUERY_STRING_KEY_";
  
  public MyLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
    super(loginFormUrl);
  }
  
  protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
    String queryString = request.getQueryString();
    
    request.getSession().setAttribute("_QUERY_STRING_KEY_", queryString);
    
    String loginFormUrl = getLoginFormUrl();
    
    return loginFormUrl + "&" + queryString;
  }
}

