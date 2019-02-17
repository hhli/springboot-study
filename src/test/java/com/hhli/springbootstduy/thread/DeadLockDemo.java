package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/2/15 9:26
 * @description
 */
public class DeadLockDemo {
    public  static final String A = "a";
    public  static final String B = "b";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(()->{
            synchronized (A){
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (B){
                synchronized (A){
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
