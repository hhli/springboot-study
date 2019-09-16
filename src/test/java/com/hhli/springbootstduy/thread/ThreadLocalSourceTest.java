package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019-09-05 15:37
 * @description threadLocal源码测试
 */
public class ThreadLocalSourceTest {

    public static void main(String[] args) {
        ThreadLocal<StringBuilder> threadLocalBuilder = new ThreadLocal<>();
        threadLocalBuilder.set(new StringBuilder("test"));
        System.out.println(threadLocalBuilder.get());

        ThreadLocal<String>  threadLocalString = new ThreadLocal<>();
        threadLocalString.set("111");
        System.out.println(threadLocalString.get());
    }
}
