package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/1/1 11:36
 * @description volatile测试
 */
public class VolatileTest {

    private static  volatile  int  race = 0;
    public static void main(String[] args) throws InterruptedException {

        for(int  i= 0; i<10; i++){
            final int temp = i;
            Thread t = new Thread(()->{
                race = temp;
                //try {
                //    Thread.sleep(1);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                System.out.println(Thread.currentThread().getName() +":"+ race);
            }, new StringBuilder("thread--").append(i).toString());
            t.start();
        }

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println("done!!!!");
    }
}
