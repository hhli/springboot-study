package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2020/1/29 11:10
 * @description 线程安全地停止
 */
public class ShutDown {

    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        SleepUtils.second(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        SleepUtils.second(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private  long i ;
        private boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }

            System.out.println("Count i=" + i);
        }

        public void cancel(){
            on = false;
        }
    }
}
