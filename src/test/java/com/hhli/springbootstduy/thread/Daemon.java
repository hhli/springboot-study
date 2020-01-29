package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2020/1/27 18:08
 * @description 后台线程测试
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try{
                SleepUtils.second(10);
            }finally {
                System.out.println("Daemon final Thread run....");
            }
        }
    }

}
