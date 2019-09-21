package com.hhli.springbootstduy.effective;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/9/20 8:35
 * @description 线程停止测试
 */
public class StopThread {
    private static boolean stopRequested;

    public static synchronized  void requestStop(){
        stopRequested = true;
    }

    public static synchronized  boolean stopRequested(){
        return stopRequested;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(()->{
            int i = 0;
            while (!stopRequested()) {
                i++;
                System.out.println(LocalTime.now());
            }
        });

        backgroundThread.setDaemon(true);
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        requestStop();
    }
}
