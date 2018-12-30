package com.hhli.springbootstduy.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 李辉辉
 * @date 2018/12/4 9:09
 * @description lockSupport测试
 */
public class LockSupportTest {

    public static void main(String[] args) throws Exception {
        //Thread mainThread = Thread.currentThread();
        //LockSupport.park();
        //LockSupport.unpark(mainThread);
        //LockSupport.park();
        //LockSupport.unpark(mainThread);
        //Thread t = new Thread(() -> LockSupport.unpark(mainThread));
        //System.out.println("block~~~");
        //t2();

        //Thread.currentThread().interrupt();
        //LockSupport.park(null);
        //System.out.println(Thread.currentThread().isInterrupted());
        //System.out.println("main~~~~~~");

        //int i = Integer.MAX_VALUE  + 1;
        //System.out.println(i);

        //Thread thread = new Thread(() -> {
        //    for (int i=0; i<10000; i++){
        //        System.out.println("i="+i);
        //    }
        //    LockSupport.park();
        //    System.out.println("end=======");
        //});
        //thread.start();
        //
        //System.out.println("main============");
        //LockSupport.unpark(thread);
        //System.out.println("main end=========");

        //LockSupport.park();
        //LockSupport.unpark(Thread.currentThread());
        //System.out.println(Thread.currentThread().isInterrupted());
        //System.out.println("main============");

        t2();
    }

    public static void t2() throws Exception {
        Thread t = new Thread(new Runnable() {
            private int count = 0;

            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待或许许可
                LockSupport.park();
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });
        t.start();
        Thread.sleep(2000);

        // 中断线程
        t.interrupt();
        System.out.println("main over");
    }

}
