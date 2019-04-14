package com.hhli.springbootstduy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 李辉辉
 * @date 2019/4/14 15:00
 * @description 动态代理handler
 */
public class MyInvocationHandler implements InvocationHandler{
    //被代理的对象
    private Object target = null;

    public MyInvocationHandler(Object obj){
        this.target = obj;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
