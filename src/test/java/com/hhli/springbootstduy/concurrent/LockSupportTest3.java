package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 李辉辉
 * @date 2020-03-29 21:31
 * @description
 */
public class LockSupportTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ParkThread());
        t.start();
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"开始唤醒阻塞线程");
        t.interrupt();
        System.out.println(Thread.currentThread().getName()+"结束唤醒");

    }
}

class ParkThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始阻塞");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+"第一次结束阻塞");
        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+"第二次结束阻塞");

        LockSupport.park();
        System.out.println(Thread.currentThread().getName()+"第三次结束阻塞");
    }
}
