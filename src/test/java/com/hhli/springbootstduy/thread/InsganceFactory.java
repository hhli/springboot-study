package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/3/7 9:04
 * @description 单例类的初始化
 */
public class InsganceFactory {
    private static  class InstanceHolder{
        public static Instance instance = new Instance();
    }

    public  static  Instance getInstance(){
        return  InstanceHolder.instance;
    }
}
