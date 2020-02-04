package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2020-02-02 20:25
 * @description thread join test
 */
public class Join {

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }

        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static  class Domino implements Runnable {
        private Thread thread;

        public  Domino(Thread thread){
            this.thread = thread;
        }


        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }

}
