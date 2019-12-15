package com.hhli.springbootstduy.stream;

/**
 * @author 李辉辉
 * @date 2019/12/15 16:22
 * @description 匿名类
 */
public class MainAnonymousClass {
    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Anonymous Class Thread run()");
            }
        }).start();;
    }
}