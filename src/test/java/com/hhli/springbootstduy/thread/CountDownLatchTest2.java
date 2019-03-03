package com.hhli.springbootstduy.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author 李辉辉
 * @date 2019/2/18 20:57
 * @description
 */
public class CountDownLatchTest2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
                System.out.println("thread name is:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(100);
                System.out.println("thread name is:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        });

        t1.start();
        t2.start();
        for (int i = 0; i < 50000; i++) {
            System.out.println(i);
        }
        countDownLatch.await();
        System.out.println(111);
    }
}
