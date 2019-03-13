package com.hhli.springbootstduy.concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/3/12 22:35
 * @description 连接驱动器
 */
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if("commit".equals(method.getName())){
                TimeUnit.MICROSECONDS.sleep(100);
            }

            return null;
        }
    }

    public  static  final Connection createConnection(){
        return  (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
    }

}
