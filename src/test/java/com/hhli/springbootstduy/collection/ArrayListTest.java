package com.hhli.springbootstduy.collection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2019/6/2 17:19
 * @description ArrayList测试
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.removeAll(Arrays.asList("1", "4"));
    }
}
