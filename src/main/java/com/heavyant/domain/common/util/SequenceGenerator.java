package com.heavyant.domain.common.util;

import java.util.Date;

/**
 * 用于tp短信服务系统的短信IP生成, 应该是tp提供的算法
 *
 * form tp ying.dong.
 */
public class SequenceGenerator {

    private static Date date = new Date();

    private static int seq = 1;

    private static final int ROTATION = 9999;

    public static synchronized Long generate() {
        if (seq > ROTATION) {
            seq = 1;
        }
        date.setTime(System.currentTimeMillis());
        String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);
        return Long.parseLong(str);
    }

}
