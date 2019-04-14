package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/14 14:59
 * @description
 */
public class RealSubject implements Subject{

    @Override
    public void doSomething(String str) {
        System.out.println("do something! --->" + str);
    }
}
