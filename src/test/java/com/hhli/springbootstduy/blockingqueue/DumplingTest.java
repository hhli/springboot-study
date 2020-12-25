package com.hhli.springbootstduy.blockingqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 12/18/20 3:29 PM
 * @description 饺子测试
 */
public class DumplingTest {
    private static  final int SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        LinkedList<String> tempList = new LinkedList<>();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread temp = new Thread(new Customer(tempList), "customer-" + i);
            temp.start();
            threadList.add(temp);
        }

        for (int i = 0; i < 10; i++) {
            Thread temp = new Thread(new Producer(tempList, SIZE), "producer-" + i);
            temp.start();
            threadList.add(temp);
        }

        for (Thread thread : threadList) {
            thread.join();
        }
    }
}
