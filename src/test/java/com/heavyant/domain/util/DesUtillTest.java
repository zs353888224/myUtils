package com.heavyant.domain.util;

import org.junit.Test;

/**
 * Created by zs on 16/8/26.
 */
public class DesUtillTest {

    @Test
    public void testFist() {
        String key1 = "dsf";
        String key2 = "dsfsdfsd";
        String key3 = "fevekvnekrvekr";
        String data = "kaoak";
        String str = DesUtil.strEnc(data, key1, key2, key3);
        System.out.println(str);
        String dec = DesUtil.strDec(str, key1, key2, key3);
        System.out.println(dec);
    }
}
