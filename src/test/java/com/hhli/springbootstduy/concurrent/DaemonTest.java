package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2019/3/10 17:48
 * @description
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonRunner(), "DaemonThread");
        t.setDaemon(Boolean.TRUE);
        t.start();
    }

    static  class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try{
                SleepUtils.second(10L);
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}