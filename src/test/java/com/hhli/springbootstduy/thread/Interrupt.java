package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2020/1/28 22:49
 * @description 中断
 */
public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println(sleepThread.getName() + " interrupted is:" + sleepThread.isInterrupted());
        System.out.println(busyThread.getName() + " interrupted is:" + busyThread.isInterrupted());

        SleepUtils.second(2);
    }

    static  class  SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
