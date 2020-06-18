package com.hhli.springbootstduy.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串操作工具类
 * @author zhangdeman001@ke.com
 */
public class StringUtil {
    private StringUtil(){}

    public static Map<String, String> transStringToMap(String mapString, String separator, String pairSeparator) {
        Map<String, String> map = new HashMap<>();

        if (null == mapString || mapString.isEmpty()) {
            return map;
        }

        String[] fSplit = mapString.split(separator);
        for (int i = 0; i < fSplit.length; i++) {
            if (fSplit[i] == null || fSplit[i].length() == 0) {
                return null;
            }
            String[] sSplit = fSplit[i].split(pairSeparator);
            String value = fSplit[i].substring(fSplit[i].indexOf(pairSeparator) + 1, fSplit[i].length());
            map.put(sSplit[0], value);
        }

        return map;
    }

    /**
     * 获取指定长度的字符串
     * @param length 字符串长度
     * @return
     * @author zhangdeman001@ke.com
     */
    public static String getRandomString(Integer length){
        return RandomStringUtils.random(length);
    }

    /**
     * 获取一个字符串的md5值
     * @return
     * @author zhangdeman001@ke.com
     */
    public static String getMd5String(String sourceString, String key) {
        if (null == sourceString || 0 == sourceString.length()) {
            sourceString = getRandomString(64);
        }
        return DigestUtils.md5Hex(sourceString + key);
    }
}
