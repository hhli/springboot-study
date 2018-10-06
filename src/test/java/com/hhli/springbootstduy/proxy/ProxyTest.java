package com.hhli.springbootstduy.proxy;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary 代理测试类
 */
public class ProxyTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //对接口实现类直接生成代理类
        //通过new的方式生成代理对象
        HelloWorld h = new HelloWorldImpl();
        HelloWorld helloWorldProxy =
                (HelloWorld) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class<?>[]{HelloWorld.class}, new MyInvocationHandler(h));
        helloWorldProxy.sayHello();

        System.out.println("======================");

        //通过接口，生成代理类类信息，然后获取构造函数类，最后传入需要代理的对象，生成代理类
        //本质上就是通过反射生成代理对象
        Class<?> proxy = Proxy.getProxyClass(ProxyTest.class.getClassLoader(), HelloWorld.class);
        final Constructor<?> cons = proxy.getConstructor(InvocationHandler.class);
        final InvocationHandler in = new MyInvocationHandler(new HelloWorldImpl());
        helloWorldProxy = (HelloWorld) cons.newInstance(in);
        helloWorldProxy.sayHello();

        System.out.println("=====================");
        helloWorldProxy.toString();
    }
}
