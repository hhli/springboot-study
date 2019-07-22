package com.hhli.springbootstduy.other;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李辉辉
 * @date 2019-06-17 18:53
 * @description 签名校验测试
 */
public class StrTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //List<String> str1 = Arrays.asList("A1单元", "A2", "B1单元", "1单元", "一单元");
        //Collections.sort(str1);
        //System.out.println(str1);
        //
        //List<String> stringList = Arrays.asList("1单元", "2单元", "10单元",  "A1单元");
        //Collections.sort(stringList);
        //System.out.println(stringList);

        Map<String, StringBuilder> temp = new HashMap<>();
        temp.put("key", new StringBuilder("1111"));
        temp.put("key2", new StringBuilder("2222OK"));

        System.out.println(temp);
    }
}
