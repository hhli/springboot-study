package com.hhli.springbootstduy.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private int times;
    private static Semaphore semaphoreA = new Semaphore(1); // 只有A 初始信号量为1,第一次获取到的只能是A
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public ThreadTest(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        ThreadTest printer = new ThreadTest(3);
        new Thread(() -> {
            printer.print("1", semaphoreA, semaphoreB);
        }).start();

        new Thread(() -> {
            printer.print("2", semaphoreB, semaphoreC);
        }).start();

        new Thread(() -> {
            printer.print("3", semaphoreC, semaphoreA);
        }).start();
    }

    private void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < times; i++) {
            try {
                current.acquire();  // A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.print(name);
                next.release();    // B释放信号，B信号量加1（初始为0），此时可以获取B信号量
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//public class ThreadTest {
//    private int times; // 控制打印次数
//    private int state;   // 当前状态值：保证三个线程之间交替打印
//    private Lock lock = new ReentrantLock();
//
//    public ThreadTest(int times) {
//        this.times = times;
//    }
//
//    private void printLetter(String name, int targetNum) {
//        for (int i = 0; i < times; ) {
//            lock.lock();
//            if (state % 3 == targetNum) {
//                state++;
//                i++;
//                System.out.println(name);
//            }
//            lock.unlock();
//        }
//    }
//
//    public static void main(String[] args) {
//        ThreadTest loopThread = new ThreadTest(3);
//
//        new Thread(() -> loopThread.printLetter("1", 0), "1").start();
//
//        new Thread(() -> loopThread.printLetter("2", 1), "2").start();
//
//        new Thread(() -> loopThread.printLetter("3", 2), "3").start();
//    }
//}