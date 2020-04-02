package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 李辉辉
 * @date 2020-03-29 22:00
 * @description 屏障测试
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args)  {
        Thread t = new Thread(()->{
            try {
                barrier.await();
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
            }
        });


        t.start();
        t.interrupt();

        try {
            barrier.await();
        } catch (InterruptedException e) {

        } catch (BrokenBarrierException e) {

        }

        System.out.println(barrier.isBroken());
    }
}

