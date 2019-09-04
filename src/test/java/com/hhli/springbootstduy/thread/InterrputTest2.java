package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019-09-04 15:06
 * @description 中断测试
 */
public class InterrputTest2 {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            //for (int i = 0; i < 100000; i++) {
            //    if (Thread.currentThread().isInterrupted()){
            //        System.out.println("中断了伤心。。。");
            //        break;
            //    }else{
            //        System.out.println("hhh:" + i);
            //    }
            //}

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("hhh");
        }

        t.interrupt();
        System.out.println("中断完成");

        if(t.isInterrupted()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
