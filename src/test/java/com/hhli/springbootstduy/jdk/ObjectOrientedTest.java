package com.hhli.springbootstduy.jdk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李辉辉
 * @date 2018/11/14 8:59
 * @description 面向对象测试
 */
public class ObjectOrientedTest {
    public static final Pattern p = Pattern.compile("\\d+");

    public static void main(String[] args) {
        Matcher matcher = p.matcher("1110号楼");
        Integer buildNo = null;
        if (matcher.lookingAt()) {
            buildNo = Integer.parseInt(matcher.group());
        }

        System.out.println(buildNo);
    }
}
