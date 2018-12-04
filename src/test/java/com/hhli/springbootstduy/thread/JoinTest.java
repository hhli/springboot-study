package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2018/12/2 21:04
 * @description join测试
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "222222222222222222222");
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                System.out.println(Thread.currentThread().getName() + "3333333333333333333");
            } catch (InterruptedException e) {
                e.printStackTrace();            }
        });

        // t.join();
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName() + "11111111111111");
    }
}
