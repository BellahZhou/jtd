package com.jtd.web.security;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.web.DefaultRedirectStrategy;

public class KeepParamRedirectStrategy extends DefaultRedirectStrategy {
  public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
    String queryString = (String)request.getSession().getAttribute("_QUERY_STRING_KEY_");
    if (queryString != null) {
      url = url + "&" + queryString;
    }
    super.sendRedirect(request, response, url);
  }
}
