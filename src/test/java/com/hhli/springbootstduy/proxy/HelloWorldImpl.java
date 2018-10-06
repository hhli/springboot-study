package com.hhli.springbootstduy.proxy;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary 接口代理实现类
 */
public class HelloWorldImpl implements HelloWorld{
    @Override
    public void sayHello() {
        System.out.println("hello, proxy!!!");
    }
}
