package com.hhli.springbootstduy.algothrims;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2020-05-25 12:20
 * @description
 */
public class TestDefalut {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(()->{
            latch.countDown();
            Thread.currentThread().interrupt();
        }).start();

        Thread.currentThread().interrupt();

        latch.await(1, TimeUnit.SECONDS);

    }

}
