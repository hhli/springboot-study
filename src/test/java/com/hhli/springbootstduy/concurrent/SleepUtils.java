package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019-03-10 15:36
 * @description
 */
public class SleepUtils {

    public static final  void second(Long second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
