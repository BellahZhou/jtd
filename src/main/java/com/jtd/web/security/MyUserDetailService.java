package com.jtd.web.security;

import com.jtd.dao.UserDao;
import com.jtd.domain.User;
import com.jtd.util.SecurityContextUtil;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {
	@Resource
	private UserDao userDao;
  
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    User user = userDao.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("用户名不存在");
    }
    Collection<GrantedAuthority> auths = new ArrayList();
    
    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_TEST");
    auths.add(authority);
    
    return new SecurityContextUtil.MyUserDetail(username, user.getPassword(), true, true, true, true, auths, user);
  }
}

