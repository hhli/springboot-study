package com.hhli.springbootstduy.proxy;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary cglib代理测试
 */
public class CglibTest {
    public static void main(String[] args) {
        HelloWorldImpl h = new HelloWorldImpl();
        h = (HelloWorldImpl)new CglibProxy(h).getProxyInstance();

        h.sayHello();

        System.out.println("====================");

        h.toString();
    }
}
