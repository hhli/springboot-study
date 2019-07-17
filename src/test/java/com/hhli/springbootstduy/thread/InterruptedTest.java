package com.hhli.springbootstduy.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李辉辉
 * @date 2019/7/13 18:10
 * @description 中断测试
 */
public class InterruptedTest {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
       Thread temp = new Thread(()->{
           try {
               testLockInterruptibly();
           } catch (InterruptedException e) {
               System.out.println("11111");
           }
       });

       temp.start();
       // for (int i = 0; i < 10; i++) {
       //     System.out.println(i);
       // }
       temp.interrupt();
    }

    /**
     * 测试线程阻塞和interrupt方法调用之间的影响
     * @throws InterruptedException
     */
    public static  void test1() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println("begin toT interrupt");
                //Thread.currentThread().interrupt();
                Thread.sleep(10000);
                System.out.println("end to interrupt");
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println("thread-t done");
        });
        t.start();
        Thread.sleep(11);
        System.out.println(t.getState());
        t.join();

        System.out.println("thread-main done");
    }

    /**
     * 测试不被检查的异常处理器
     */
    public static  void test2(){
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("哈哈哈···");
        });


       Thread temp =  new Thread(()->{
            int i = 0;
            System.out.println(1/i);
        });
        temp.start();
    }


    public static void testLockInterruptibly() throws InterruptedException {
        System.out.println("begin to get lock");
        lock.lockInterruptibly();
        System.out.println("end to get lock");
        
        try{
            Thread.sleep(111);
        }finally {
            lock.unlock();
        }
    }
}
