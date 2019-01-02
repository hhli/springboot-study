package com.hhli.springbootstduy.thread;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/1/1 10:53
 * @description dcl的单利模式
 */
public class Singleton {
    //private static final  Singleton instatnce;
    //static {j0po
    //    instatnce = new Singleton();
    //}

    private static   volatile  Singleton instatnce = null;

    public  static  Singleton getInstatnce(){
        if(Objects.isNull(instatnce)){
            synchronized (Singleton.class){
                if(Objects.isNull(instatnce)){
                    instatnce = new Singleton();
                }
            }
        }

        return  instatnce;
    }

    public static void main(String[] args) {
        Singleton.getInstatnce();
    }
}
