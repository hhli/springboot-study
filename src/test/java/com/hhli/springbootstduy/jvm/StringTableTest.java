package com.hhli.springbootstduy.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/1/7 9:22
 * @description 字符串测试
 */
public class StringTableTest {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringTableTest test = new StringTableTest();
        long ms = test.intern(1000000);
        System.out.println(ms);
    }
    public long intern(int times) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            String.valueOf(i).intern();
        }
        return System.currentTimeMillis() - start;
    }
}