package com.hhli.springbootstduy.blockingqueue;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李辉辉
 * @date 12/27/20 9:44 AM
 * @description 生产者消费者测试
 */
public class CPTest2 {
    private static Integer count = 0;
    private static final Integer FULL = 10;

    private Lock lock = new ReentrantLock();

    //创建两个环境变量
    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        CPTest2 test2 = new CPTest2();
        new Thread(test2.new Producer(), "p-1").start();
        new Thread(test2.new Consumer(), "c-1").start();
        new Thread(test2.new Producer(), "p-2").start();
        new Thread(test2.new Consumer(), "c-2").start();
        new Thread(test2.new Producer(), "p-3").start();
        new Thread(test2.new Consumer(), "c-3").start();
        new Thread(test2.new Producer(), "p-4").start();
        new Thread(test2.new Consumer(), "c-4").start();
    }


    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                try{
                    while(FULL.equals(count)){
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    notEmpty.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }


    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                try{
                    while(NumberUtils.INTEGER_ZERO.equals(count)){
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总还有" + count);
                    notFull.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}


