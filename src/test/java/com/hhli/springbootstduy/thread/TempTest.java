package com.hhli.springbootstduy.thread;

import java.util.regex.Pattern;

/**
 * @author 李辉辉
 * @date 2019-08-01 14:34
 * @description
 */
public class TempTest {

    public static void main(String[] args) {
        //^([1][:][0-3]|[1][:][0-2][.][0-9]+|1:3.0[0]*|\\s|\d+)$
        Pattern pattern = Pattern.compile("^([1][:][0-3]|[1][:][0-2][.][0-9]+|1.0[0]*|\\\\s|[0-3]|[0-2][.][0-9]+|1.0[0]*)$");
        System.out.println(pattern.matcher("1.0").matches());
    }
}
