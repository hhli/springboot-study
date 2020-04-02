package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 李辉辉
 * @date 2020-03-28 22:50
 * @description LockSupport测试
 */
public class LockSupportTest {

    public static void main(String[] args) {
        //Object obj = new Object();
        //Thread t1 = new Thread(()->{
        //    LockSupport.park(obj);
        //    System.out.println("park done:" + LocalDateTime.now());
        //    System.out.println("t1 done~~~");
        //});
        //
        //t1.start();
        //
        //System.out.println("unpark begin:" + LocalDateTime.now());
        ////LockSupport.unpark(t1);
        //t1.interrupt();
        //System.out.println("unpark end:" + LocalDateTime.now());
        //
        //System.out.println("main done~~~");

        Thread thread = Thread.currentThread();

        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");

        //LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("c");

    }

    public final boolean parkAndCheckInterrupt() {
        LockSupport.park(LockSupport.getBlocker(Thread.currentThread()));
        Thread.currentThread().interrupt();
        return Thread.interrupted();
    }
}
