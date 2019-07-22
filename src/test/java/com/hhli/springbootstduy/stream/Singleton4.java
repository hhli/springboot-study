package com.hhli.springbootstduy.stream;

/**
 * @author 李辉辉
 * @date 2019/7/21 10:25
 * @description
 */
public class Singleton4 {

    private Singleton4() {

    }

    private static class SignletonHolder {

        public static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SignletonHolder.INSTANCE;
    }

    /**
     * 反序列化一旦发现有readResolve方法，则直接调用readResolve方法返回的对象
     * @return
     */
    private   Object readResolve(){
        return SignletonHolder.INSTANCE;
    }
}
