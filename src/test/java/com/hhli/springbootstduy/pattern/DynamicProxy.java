package com.hhli.springbootstduy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 李辉辉
 * @date 2019/4/14 15:04
 * @description
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader cl, Class<?>[] interfaces , InvocationHandler h){
        if(true){
            //执行一个前置通知
            new BeforeAdvice().exec();
        }
        //执行目标，并返回结果
        return  (T) Proxy.newProxyInstance(cl, interfaces, h);
    }
}
