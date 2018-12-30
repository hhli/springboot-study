package com.hhli.springbootstduy.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2018/12/10 12:28
 * @description 数组测试
 */
public class ArrayTest {

    public static void main(String[] args) {
        List<String>  stringList  = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        String[] strArray = new String[stringList.size()];
        stringList.toArray(strArray);

        System.out.println(Arrays.toString(strArray));
    }
}
