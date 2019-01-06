package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/1/6 21:16
 * @description 死锁测试
 */
public class DeadLockTest {

    public static void main(String[] args) {
        new Thread(new SynAddRunnable(1, 2)).start();
        new Thread(new SynAddRunnable(2, 1)).start();
    }

    static class SynAddRunnable implements Runnable{
        int a;
        int b;

        public  SynAddRunnable(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Integer.valueOf(b)){
                    System.out.println(a + b);
                }
            }
        }
    }
}
