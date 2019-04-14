package com.hhli.springbootstduy.pattern;

import java.lang.reflect.InvocationHandler;

/**
 * @author 李辉辉
 * @date 2019/4/14 15:09
 * @description
 */
public class Client2 {

    public static void main(String[] args) {
        //定义一个主题
        Subject subject = new RealSubject();
        //定义一个handler
        InvocationHandler h = new MyInvocationHandler(subject);

        //定义主题的代理
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), h);

        //代理的行为
        proxy.doSomething("Finish");
    }
}
