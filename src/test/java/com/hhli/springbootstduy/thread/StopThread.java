package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019-09-19 20:46
 * @description 停止线程测试
 */
public class StopThread {
    private static boolean stopThread = false;

    public static void main(String[] args) {
        Thread backGroundThread = new Thread(()->{
            int i = 0;
            while (!stopThread)
                i++;
        });
    }
}
