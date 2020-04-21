package com.hhli.springbootstduy.algothrims;

import com.hhli.springbootstduy.thread.SleepUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 李辉辉
 * @date 2020-04-20 14:47
 * @description 输出最先查询翻译出来的数据
 */
public class TranslateTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> result = new ArrayBlockingQueue<>(1);

        //获取翻译结果
        TranslateTest test = new TranslateTest();
        String content = "11";
        new Thread(() -> {
            long begin = System.currentTimeMillis();
            String temp = test.baidu(content);
            long end = System.currentTimeMillis();
            result.offer(temp);

            System.out.println("test.baidu:" + (end-begin) + "ms");
        }).start();

        new Thread(() -> {
            long begin = System.currentTimeMillis();
            String temp = test.google(content);
            long end = System.currentTimeMillis();
            result.offer(temp);

            System.out.println("test.google:" + (end-begin) + "ms");

        }).start();

        new Thread(() -> {
            long begin = System.currentTimeMillis();
            String temp = test.youdao(content);
            long end = System.currentTimeMillis();
            result.offer(temp);

            System.out.println("test.youdao:" + (end-begin) + "ms");
        }).start();

        while (result.isEmpty()){

        }

        System.out.println("====================================");
        System.out.println("result:" + result.peek());
        System.out.println("====================================");
    }


    public String baidu(String content){
        SleepUtils.millsecond(ThreadLocalRandom.current().nextInt(3000));
        return "baidu:" + content;
    }


    public String google(String content) {
        SleepUtils.millsecond(ThreadLocalRandom.current().nextInt(3000));
        return "google:" + content;
    }


    public String youdao(String content){
        SleepUtils.millsecond(ThreadLocalRandom.current().nextInt(3000));
        return "youdao:" + content;
    }
}
