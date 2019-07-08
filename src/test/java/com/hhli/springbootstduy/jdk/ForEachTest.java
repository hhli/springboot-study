package com.hhli.springbootstduy.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/6/17 8:58
 * @description
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<String> tempList = new ArrayList<>();
        tempList.add("1");
        tempList.add("2");
        tempList.add("3");
        tempList.add("5");

        for (String s : tempList) {
            System.out.println(s);
        }

        List<String> stringList = tempList.subList(0, 2);
        stringList.add("5");
        for (String s : tempList) {
            System.out.println(s);
        }

        //int[] a = new int[]{1, 2, 3};
        //for (int i : a) {
        //    System.out.println(i);
        //}
    }
}
