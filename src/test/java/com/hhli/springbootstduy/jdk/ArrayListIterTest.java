package com.hhli.springbootstduy.jdk;

import java.util.*;

/**
 * @author 李辉辉
 * @date 2019/7/8 9:38
 * @description
 */
public class ArrayListIterTest {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
        }};

        Spliterator<String> spliterator = strList.spliterator();
    }
}
