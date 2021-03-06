package com.hhli.springbootstduy.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/3/11 22:21
 * @description 等待通知测试
 */
public class WaitNotify {
    static  boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static  class Wait implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (flag){
                    System.out.println(Thread.currentThread() + " flag is true. wait "
                            + "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread() + " flag is false. running "
                        + "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }


    static  class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                //获取locK的锁，然后进行通知，通知时不会释放锁
                // 直到当前释放了lock后，WaitThread才能从wait返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));

                lock.notifyAll();
                flag = false;
                SleepUtils.second(5L);
            }

            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock again. sleep "
                        + "@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5L);
            }
        }
    }
}


