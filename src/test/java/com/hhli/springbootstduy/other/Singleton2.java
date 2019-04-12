package com.hhli.springbootstduy.other;

/**
 * @author 李辉辉
 * @date 2019-04-07 20:33
 * @description 使用双重锁处理单例
 */
public class Singleton2 {
    private static  volatile  Singleton2 instance = null;

    private Singleton2(){

    }

    public  static  Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }
}
