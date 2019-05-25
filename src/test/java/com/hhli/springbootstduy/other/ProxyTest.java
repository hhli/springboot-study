package com.hhli.springbootstduy.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author 李辉辉
 * @date 2019/5/25 16:44
 * @description 代理测试
 */
public class ProxyTest {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        for (int i = 0; i < elements.length; i++) {
            Integer valve = i+1;
            InvocationHandler handler = new TraceHandler(valve);
            Object proxy = Proxy.newProxyInstance(null, new  Class[]{Comparable.class}, handler);
            Class temp = proxy.getClass();
            System.out.println(Modifier.toString(temp.getModifiers()) + " "+ temp.getName());
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);

        if(result > 0){
            System.out.println(elements[result]);
        }
    }
}

class TraceHandler implements InvocationHandler{
    private Object target;

    public  TraceHandler(Object target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i < args.length-1) System.out.print(", ");
            }
        }
        System.out.println(")");

        return method.invoke(target, args);
    }
}
