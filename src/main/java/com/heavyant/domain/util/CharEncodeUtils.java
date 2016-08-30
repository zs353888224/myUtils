package com.heavyant.domain.util;


import java.io.UnsupportedEncodingException;

/**
 * 不知道他们在哪里弄的黑科技, 不明觉厉(懒得测试)
 * form tp
 */
public class CharEncodeUtils {
    private final static char[] HEX = "0123456789abcdef".toCharArray();

    public static void main(String[] args) throws Exception {
        String ucs4HexSequence = "0034 20E3";
        System.out.println(fromUcs4HexSequenceToString(ucs4HexSequence));
    }

    public static boolean containGte4BytesUtf8(String text) {
        if (text != null) {
            try {
                byte[] bs = text.getBytes("UTF-8");
                for (byte s : bs) {
                    if ((s & Byte.parseByte("11110000", 2)) == Byte.parseByte("11110000", 2)) {
                        return true;
                    }
                }
            } catch (UnsupportedEncodingException ignored) {
            }
        }
        return false;
    }

    public static String fromUcs4HexSequenceToString(String ucs4HexSequence) {

        byte[] b = fromUcs4HexSequenceToUtf8(ucs4HexSequence);
        try {
            return new String(b, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] fromUcs4HexSequenceToUtf8(String ucs4HexSequence) {

        String[] array = ucs4HexSequence.split("\\s+");
        int length = 0;

        byte[][] bb = new byte[array.length][];
        for (int i = 0; i < array.length; i++) {
            bb[i] = fromUcs4HexToUtf8(array[i]);
            length += bb[i].length;
        }

        byte[] result = new byte[length];
        int destPos = 0;
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(bb[i], 0, result, destPos, bb[i].length);
            destPos += bb[i].length;
        }
        return result;
    }

    public static byte[] fromUcs4HexToUtf8(String ucs4Hex) {
        long ucs4 = Long.parseLong(ucs4Hex, 16);
        return fromUcs4ToUtf8(ucs4);
    }

    public static byte[] fromUcs4ToUtf8(long ucs4) {
        long utf8 = 0;
        int length = 0;
        if (ucs4 >= 0x0L && ucs4 <= 0x7fL) {
            utf8 = ucs4;
            length = 1;
        } else if (ucs4 >= 0x80L && ucs4 <= 0x7FFL) {
            utf8 = Long.parseLong("11000000_10000000", 2);
            utf8 += ucs4 & Long.parseLong("111111L", 2);
            utf8 += (ucs4 >> 6 & Long.parseLong("111111", 2)) << 8;
            length = 2;
        } else if (ucs4 >= 0x800L && ucs4 <= 0xffffL) {
            utf8 = Long.parseLong("11100000_10000000_10000000", 2);
            utf8 += ucs4 & Long.parseLong("111111L", 2);
            utf8 += (ucs4 >> 6 & Long.parseLong("111111L", 2)) << 8;
            utf8 += (ucs4 >> 12 & Long.parseLong("111111L", 2)) << 16;
            length = 3;
        } else if (ucs4 >= 0x10000 && ucs4 <= 0x1FFFFF) {
            utf8 = Long.parseLong("11110000_10000000_10000000_10000000");
            utf8 += ucs4 & Long.parseLong("111111", 2);
            utf8 += (ucs4 >> 6 & Long.parseLong("111111L", 2)) << 8;
            utf8 += (ucs4 >> 12 & Long.parseLong("111111", 2)) << 16;
            utf8 += (ucs4 >> 18 & Long.parseLong("111111", 2)) << 24;
            length = 4;
        } else if (ucs4 >= 0x200000 && ucs4 <= 0x3FFFFFF) {
            utf8 = Long.parseLong("11111000_10000000_10000000_10000000_10000000", 2);
            utf8 += ucs4 & Long.parseLong("111111", 2);
            utf8 += (ucs4 >> 6 & Long.parseLong("111111", 2)) << 8;
            utf8 += (ucs4 >> 12 & Long.parseLong("111111", 2)) << 16;
            utf8 += (ucs4 >> 18 & Long.parseLong("111111", 2)) << 24;
            utf8 += (ucs4 >> 24 & Long.parseLong("111111", 2)) << 32;
            length = 5;
        } else if (ucs4 >= 4000000 && ucs4 <= 0x7FFFFFFF) {
            utf8 = Long.parseLong("11111100_10000000_10000000_10000000_10000000_10000000", 2);
            utf8 += ucs4 & Long.parseLong("111111", 2);
            utf8 += (ucs4 >> 6 & Long.parseLong("111111", 2)) << 8;
            utf8 += (ucs4 >> 12 & Long.parseLong("111111", 2)) << 16;
            utf8 += (ucs4 >> 18 & Long.parseLong("111111", 2)) << 24;
            utf8 += (ucs4 >> 24 & Long.parseLong("111111", 2)) << 32;
            utf8 += (ucs4 >> 30 & Long.parseLong("111111", 2)) << 40;
            length = 6;
        }

        return longToByteArray(utf8, length);
    }

    private static byte[] longToByteArray(long n, int length) {
        byte[] b = new byte[length];
        for (int i = 0; i < length; i++) {
            b[length - i - 1] = (byte) ((n >> 8 * i) & 0xFF);
        }
        return b;
    }

    public static String bytes2HexString(byte[] bys) {


        char[] chs = new char[bys.length * 2 + bys.length - 1];
        for (int i = 0, offset = 0; i < bys.length; i++) {
            if (i > 0) {
                chs[offset++] = ' ';
            }
            chs[offset++] = HEX[bys[i] >> 4 & 0xf];
            chs[offset++] = HEX[bys[i] & 0xf];
        }
        return new String(chs);
    }
}