package com.heavyant.domain.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;

/**
 * 简单对URL进行加密, 可用于用户需要分享链接🈶️3不用直接跟其展示的场景
 * form tp Alex
 */
public class UrlEncodeUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(UrlEncodeUtils.class);

    /**
     * 加密String明文输入,String密文输出
     *
     * @param strMing
     * @return
     */
    public static String encode(String strMing) {
        return new String(Base64.encode((strMing.getBytes())));
    }

    /**
     * 解密 以String密文输入,String明文输出
     *
     * @param strMi
     * @return
     */
    public static String decode(String strMi) {
        try {
            return new String(Base64.decode(strMi.getBytes()));
        } catch (Exception e) {
            LOGGER.error("failed to decode {}", strMi);
            throw new RuntimeException(e);
        }
    }
}
