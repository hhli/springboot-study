package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2020-04-06 17:09
 * @description
 */
public class TwinsLockTest {
    static final TwinsLock lock = new TwinsLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
           Thread t =  new Thread(()->{
                while (true) {
                    lock.lock();
                    try{
                        SleepUtils.second(1L);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1L);
                    }finally {
                        lock.unlock();
                    }
                }
            });

           t.setDaemon(true);
           t.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1L);
            System.out.println();
        }
    }

}


