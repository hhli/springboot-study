package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 李辉辉
 * @date 2020-03-29 22:00
 * @description 屏障测试
 */
public class CyclicBarrierTest {
    static CyclicBarrier barrier = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(()->{
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }).start();

        new Thread(()->{
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("2");
        }).start();
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println("3");
        }
    }
}

