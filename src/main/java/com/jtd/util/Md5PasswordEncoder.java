package com.jtd.util;

public class Md5PasswordEncoder extends org.springframework.security.authentication.encoding.Md5PasswordEncoder {

    private String preffix = "{3DES}";

    private String suffix = "";

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        return encPass.equals(encodePassword(rawPass, salt));
    }

    @Override
    public String encodePassword(String rawPass, Object salt) {
        String encodePassword = super.encodePassword(rawPass, salt);
        encodePassword = preffix + encodePassword + suffix;
        return super.encodePassword(encodePassword, salt);
    }
}
