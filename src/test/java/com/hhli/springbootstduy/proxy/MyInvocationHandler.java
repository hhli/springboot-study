package com.hhli.springbootstduy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
public class MyInvocationHandler implements InvocationHandler{
    private Object target;

    public MyInvocationHandler(Object object){
        this.target  = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method:" + method.getName() + " begin to invoke");
        method.invoke(target, args);
        System.out.println("method:" + method.getName() + " end to invoke");

        return null;
    }
}
