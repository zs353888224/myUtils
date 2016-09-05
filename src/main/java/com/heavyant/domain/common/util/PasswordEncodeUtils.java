package com.heavyant.domain.common.util;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * 一种密码加密方式, 在RECLO里使用spring secret代理加密
 */
public abstract class PasswordEncodeUtils {

    public static String encodePassword(String rawPass, Object salt){
    	ShaPasswordEncoder sha = new ShaPasswordEncoder();
        sha.setEncodeHashAsBase64(false);
        return sha.encodePassword(rawPass, salt);
   }

   public static String generateSalt(){
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
   }
}
