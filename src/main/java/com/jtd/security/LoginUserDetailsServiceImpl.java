package com.jtd.security;

import com.jtd.entity.User;
import com.jtd.security.LoginUserDetailsImpl;
import com.jtd.security.LoginUserDetailsService;
import com.jtd.service.IUserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

public class LoginUserDetailsServiceImpl implements LoginUserDetailsService {
	@Resource
	private IUserService userService;
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
    		return true;
    	}
        /*if ("zhouyan".equals(username) && "00000000".equals(password)) {
            return true;
        }*/
        return false;
    }

}