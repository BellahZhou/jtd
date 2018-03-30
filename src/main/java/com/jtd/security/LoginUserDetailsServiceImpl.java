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
     * ���е�¼��֤
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
     * �ڴ˴���֤
     * @param username
     * @param password
     * @return
     */
    private boolean validate(String username, String password) {
        /**
         * �˴�Ӧ�������ݿ��ȡ�û���Ϣ������֤
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