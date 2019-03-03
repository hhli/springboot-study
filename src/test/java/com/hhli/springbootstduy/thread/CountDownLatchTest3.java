package com.hhli.springbootstduy.thread;

import java.util.concurrent.*;

/**
 * @author 李辉辉
 * @date 2019/2/18 21:02
 * @description
 */
public class CountDownLatchTest3 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                System.out.println("thread name is:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });

        executor.execute(() -> {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                System.out.println("thread name is:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });


        for (int i = 0; i < 5000; i++) {
            System.out.println(i);
        }

        System.out.println(latch.getCount());
        latch.await();

        ((ExecutorService)executor).shutdown();
    }
}