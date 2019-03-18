package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2019/3/16 22:48
 * @description wait方法测试
 */
public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().wait();
    }
}
