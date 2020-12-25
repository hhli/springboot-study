package com.hhli.springbootstduy.blockingqueue;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 12/18/20 3:13 PM
 * @description 消费者任务
 */
public class Customer implements Runnable {

    private final LinkedList<String> dumplingList;

    public Customer(LinkedList<String> tempList){
        dumplingList = tempList;
    }

    @Override
    public void run() {
        synchronized (dumplingList){
            while (dumplingList.isEmpty()){
                try {
                    dumplingList.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("eat dumpling interrupted exception");
                }
            }

            System.out.println(Thread.currentThread() + " eat dumpling:" + dumplingList.poll());

            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("make dumpling sleep interrupted exception");
            }

            dumplingList.notifyAll();
        }
    }
}
