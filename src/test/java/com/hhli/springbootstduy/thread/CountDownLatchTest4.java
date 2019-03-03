package com.hhli.springbootstduy.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author 李辉辉
 * @date 2019/2/19 11:07
 * @description
 */
public class CountDownLatchTest4 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(0);
        latch.await();
        System.out.println("hhhhhh");
    }
}
