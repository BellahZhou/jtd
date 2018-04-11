package com.jtd.security;

import com.jtd.entity.User;
import com.jtd.entity.UserAttends;
import com.jtd.security.LoginUserDetailsImpl;
import com.jtd.security.LoginUserDetailsService;
import com.jtd.service.IUserService;
import com.jtd.service.UserAttendsService;
import com.jtd.service.impl.UserServiceImpl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Service("LoginUserDetailsServiceImpl")
public class LoginUserDetailsServiceImpl  implements LoginUserDetailsService {
	@Resource
	private IUserService userService;
	@Resource
	private UserAttendsService userAttendsService;
    /**
     * 进行登录验证
     */
    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {
        boolean result = this.validate(username, password);
        if (!result) {
            return null;
        }
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        LoginUserDetailsImpl user = new LoginUserDetailsImpl(username, password,authorities);
        return user;
    }

    /**
     * 在此处验证
     * @param username
     * @param password
     * @return
     */
    private boolean validate(String username, String password) {
        /**
         * 此处应该在数据库获取用户信息进行验证
         */
    	List<User> users=userService.selectByUsernamePassword(username, password);
    	if(users.size()>0){
    		UserAttends userAttends=userAttendsService.selectByUser(users.get(0));
    		if(userAttends==null){
    			UserAttends uAttends=new UserAttends();
    			uAttends.setUserId(users.get(0).getId());
    			uAttends.setUserName(users.get(0).getUsername());
    			uAttends.setAttends((long) 1);
    			uAttends.setCreateBy("admin");
    			uAttends.setCreateDate(new Date());
    			uAttends.setUpdateBy("admin");
    			uAttends.setUpdateDate(new Date());
    			userAttendsService.insert(uAttends);
    		}else{
    			userAttends.setUpdateDate(new Date());
    			userAttends.setAttends(userAttends.getAttends()+1);
    			userAttendsService.update(userAttends);
    		}
    		return true;
    	}
        /*if ("zhouyan".equals(username) && "00000000".equals(password)) {
            return true;
        }*/
        return false;
    }

}