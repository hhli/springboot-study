package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/1/2 21:26
 * @description 线程启动两次测试
 */
public class StartTest {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);

        Thread t = new Thread(()->{
            System.out.println("1111111");
        });

        t.start();
        System.out.println("done");
    }
}
