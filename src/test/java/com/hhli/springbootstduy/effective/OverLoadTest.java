package com.hhli.springbootstduy.effective;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 李辉辉
 * @date 2019-10-09 11:30
 * @description  重载测试
 */
public class OverLoadTest {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Set<Integer> intSet = new HashSet<>();

        for(int i = -3; i<=3; i++){
            intList.add(i);
            intSet.add(i);
        }

        System.out.println("list=" + intList);
        System.out.println("set=" + intSet);

        for (int i = 0; i < 3; i++) {
            intList.remove(i);
            intSet.remove(i);
        }

        System.out.println("list=" + intList);
        System.out.println("set=" + intSet);

        test(1, 1);
    }

    static  void test(int l, Integer l1){

    }

    static  void test(int l, int l1){

    }

}
