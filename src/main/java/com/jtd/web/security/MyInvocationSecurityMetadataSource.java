package com.jtd.web.security;
import java.io.IOException;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
  
import org.springframework.security.access.SecurityMetadataSource;  
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;  
import org.springframework.security.access.intercept.InterceptorStatusToken;  
import org.springframework.security.web.FilterInvocation;  
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;  
  
public class MyInvocationSecurityMetadataSource extends AbstractSecurityInterceptor implements Filter{  
  
    //�����ļ�ע��  
    private FilterInvocationSecurityMetadataSource securityMetadataSource;  
      
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {  
        return securityMetadataSource;  
    }  
  
    public void setSecurityMetadataSource(  
            FilterInvocationSecurityMetadataSource securityMetadataSource) {  
        this.securityMetadataSource = securityMetadataSource;  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub\  
          
        FilterInvocation fi = new FilterInvocation(request, response, chain);  
        //fi������һ�������ص�url  
        //�������MyInvocationSecurityMetadataSource��getAttributes(Object object)���������ȡfi��Ӧ������Ȩ��  
        //�ٵ���MyAccessDecisionManager��decide������У���û���Ȩ���Ƿ��㹻  
        InterceptorStatusToken token = super.beforeInvocation(fi);  
        try {  
            //ִ����һ��������  
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());     
        } finally {   
            super.afterInvocation(token, null);    
        }     
          
    }  
  
    @Override  
    public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public Class<?> getSecureObjectClass() {  
        // TODO Auto-generated method stub  
        return FilterInvocation.class;   
    }  
  
    @Override  
    public SecurityMetadataSource obtainSecurityMetadataSource() {  
        // TODO Auto-generated method stub  
        return this.securityMetadataSource;     
    }  
  
    @Override  
    public void destroy() {  
        // TODO Auto-generated method stub  
    }  
}  