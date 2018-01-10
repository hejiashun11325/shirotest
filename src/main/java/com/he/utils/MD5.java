package com.he.utils;

import java.security.MessageDigest;

/**
 * @author: hejiashun
 * @Date: 2018/1/8
 * Description:
 */
public class MD5 {
    /**
     * 获得MD5的16进制串
     *
     * @param text
     * @return
     */
    public static String getHexMD5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] hash = md.digest();
            return getHexDump(hash).toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 获得dump字符串
     *
     * @param buffer
     * @return
     */
    public static String getHexDump(byte[] buffer) {
        String dump = "";
        StringBuilder builder = new StringBuilder();
        try {
            int dataLen = buffer.length;
            for (int i = 0; i < dataLen; i++) {
                // modified "concatenates strings using + in a loop" zcg
                // 2011-08-11
                builder.append(Character.forDigit((buffer[i] >> 4) & 0x0f, 16));
                builder.append(Character.forDigit(buffer[i] & 0x0f, 16));
            }
            dump = builder.toString();
        } catch (Throwable t) {
            dump = "Throwable caught when dumping = " + t;
        }
        return dump;
    }
}
