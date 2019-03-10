package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/3/7 9:08
 * @description  基于DCL的单例
 */
public class SafeDoubleCheckedLocking {
    private static  volatile  Instance instance;

    public  static Instance getInstance(){
        if(instance == null){
            synchronized (SafeDoubleCheckedLocking.class){
                if(instance == null){
                    instance = new Instance();
                }
            }
        }

        return instance;
    }
}
