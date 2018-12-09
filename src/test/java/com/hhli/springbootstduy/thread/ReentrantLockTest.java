package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李辉辉
 * @date 2018/12/9 16:45
 * @description 重入锁测试
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        //公平锁
        ReentrantLock fairLock =  new ReentrantLock(Boolean.TRUE);
        for(int i= 0; i<10; i++){
            Thread t1 = new Thread(() -> {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fairLock.unlock();
                System.out.println(Thread.currentThread().getName() + " release lock");
            });
            t1.start();
        }
    }
}
