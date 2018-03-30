package com.jtd.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginUserDetailsService {
    /**
     * �����û���������֤�û���Ϣ
     * @param username �û���
     * @param password ����
     * @return
     * @throws UsernameNotFoundException
     */
    UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;
}