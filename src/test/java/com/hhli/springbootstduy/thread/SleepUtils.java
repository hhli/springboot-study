package com.hhli.springbootstduy.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2020/1/27 17:41
 * @description
 */
public class SleepUtils {

    public static  final void   second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
