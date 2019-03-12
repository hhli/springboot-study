package com.hhli.springbootstduy.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019-03-10 21:36
 * @description 线程暂停、恢复、停止测试
 */
public class DeprecatedTest {

    public static void main(String[] args) throws InterruptedException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(Boolean.TRUE);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);

        //暂停
        //不会释放锁，容易出现死锁问题
        printThread.suspend();
        System.out.println("main suspend PrintThread at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //恢复
        printThread.resume();
        System.out.println("main resume PrintThread at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //终止
        //stop不会保证资源的正常释放、也没有给予线程释放资源的机会
        printThread.stop();
        System.out.println("main stop PrintThread at " + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static  class Runner implements Runnable{

        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName() + " Run at " + format.format(new Date()));
                SleepUtils.second(1L);
            }
        }
    }


}
