package com.hhli.springbootstduy.other;

/**
 * @author 李辉辉
 * @date 2019/1/2 21:54
 * @description
 */
public class LazySingleton {
    private static LazySingleton instance = null;
    /**
     * 私有默认构造子
     */
    private LazySingleton(){}
    /**
     * 静态工厂方法
     */
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}