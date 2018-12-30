package com.hhli.springbootstduy.model.other;

/**
 * @author 李辉辉
 * @date 2018/12/30 18:27
 * @description
 */
public class RunTimeConstantOOM {

    public static void main(String[] args) {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
