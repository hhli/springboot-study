package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019/5/16 9:33
 * @description protected 本包以及字类都可以访问
 */
public class Person3 {
    Person2 p2;

    public void test(){
        System.out.println(p2.name);
        System.out.println(p2.getName());
    }
}
