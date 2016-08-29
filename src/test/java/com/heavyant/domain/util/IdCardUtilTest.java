package com.heavyant.domain.util;

import org.junit.Test;

/**
 * Created by zs on 16/8/26.
 */
public class IdCardUtilTest {

    @Test
    public void testIdCard(){
//        System.out.println(CheckIdCardUtil.validateCard("511024198802040193"));
//        System.out.println(CheckIdCardUtil.isNum("123123"));
        System.out.println("^[0-9]*{1}".matches("51102419880204019"));
    }
}
