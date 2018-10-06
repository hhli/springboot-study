package com.hhli.springbootstduy.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
public class CglibProxy implements MethodInterceptor{
    private Object target;

    public CglibProxy(Object obj){
        this.target = obj;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return  enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib begin to invoke method:" + method.getName());
//        method.invoke(target, objects);
        methodProxy.invokeSuper(o, objects);
        System.out.println("cglib begin to invoke method:" + method.getName());

        return null;
    }
}
