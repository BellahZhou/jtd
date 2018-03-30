package com.jtd.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginUserDetailsService {
    /**
     * 根据用户名密码验证用户信息
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;
}