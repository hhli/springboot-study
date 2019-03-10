package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2019-03-10 15:35
 * @description 线程状态测试类
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();

        new Thread(new Blocked(), "BlockThread-1").start();
        new Thread(new Blocked(), "BlockThread-2").start();
    }

    //
    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(100L);
            }
        }
    }

    static  class Waiting implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try{
                        Waiting.class.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static  class  Blocked implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (Blocked.class){
                    while (true){
                        SleepUtils.second(100L);
                    }
                }
            }
        }
    }
}
