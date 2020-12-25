package com.hhli.springbootstduy.blockingqueue;

import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 12/18/20 3:13 PM
 * @description 生产者任务
 */
public class Producer implements Runnable {
    private final int size;
    private final LinkedList<String> dumplingList;

    public Producer(LinkedList<String> tempList, int size){
        dumplingList = tempList;
        this.size = size;
    }

    @Override
    public void run() {
        synchronized (dumplingList){
            while (dumplingList.size() == size){
                try {
                    dumplingList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String temp = UUID.randomUUID().toString().replace("-", "");
            System.out.println(Thread.currentThread() + " make dumpling:" + temp);
            dumplingList.add(temp);
            if(!dumplingList.isEmpty()){
                dumplingList.notifyAll();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("make dumpling sleep interrupted exception");
            }
        }
    }
}
