package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2019/3/10 17:56
 * @description
 */
public class InterruptedTest {

    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(Boolean.TRUE);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(Boolean.TRUE);

        sleepThread.start();
        busyThread.start();

        SleepUtils.second(5L);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is:" + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is:" + busyThread.isInterrupted());

        SleepUtils.second(2L);
    }

    static  class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10L);
            }
        }
    }

    static class BusyRunner implements  Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
