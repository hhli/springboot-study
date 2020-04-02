package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2020-03-28 15:15
 * @description synchronized中断测试
 */
public class SynchronizedInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            synchronized (SynchronizedInterrupt.class){
                while (true){
                    System.out.println("tt");
                }
            }
        });

        t.start();

        Thread.sleep(100);

        t.interrupt();

        System.out.println("done~~~");
    }
}
