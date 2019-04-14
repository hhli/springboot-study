package com.hhli.springbootstduy.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 李辉辉
 * @date 2019/4/13 21:44
 * @description
 */
public class GamePlayerIH implements InvocationHandler {
    //被代理者
    Class cls = null;
    //被代理者的实例
    Object obj = null;

    public GamePlayerIH(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);
        return result;
    }
}
