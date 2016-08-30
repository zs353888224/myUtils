package com.heavyant.domain.util;

import org.junit.Test;

/**
 * Created by zs on 16/8/29.
 */
public class PasswordEncodeUtilsTest {

    @Test
    public void testDSSA(){
        String ss = PasswordEncodeUtils.encodePassword("","");
        System.out.println(ss);
        System.out.println(PasswordEncodeUtils.generateSalt());
    }
}
