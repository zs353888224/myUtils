package com.heavyant.domain.util;

import org.junit.Test;

/**
 * Created by zs on 16/8/29.
 */
public class encodeUtilTest {

    @Test
    public void testFist(){
        String name = "zhangshuai";
        String ecode = "UTF-8";

        String result = MD5Util.MD5Encode(name,ecode);

        System.out.println(result);
        System.out.println(MD5Util.MD5Encode(result, ecode));
    }

    @Test
    public void testEncode(){
        String str = "zhangshuai";
        String strEn = UrlEncodeUtils.encode(str);
        System.out.println(strEn);
        System.out.println(UrlEncodeUtils.decode(strEn));

    }

    @Test
    public void testSequenceGenerator(){
        Long tt = SequenceGenerator.generate();
        System.out.println(tt);
    }
}
