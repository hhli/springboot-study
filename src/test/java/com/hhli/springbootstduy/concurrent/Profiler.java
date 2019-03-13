package com.hhli.springbootstduy.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/3/12 9:29
 * @description
 */
public class Profiler {
    private  static final ThreadLocal<Long>  TIME_THREADLOCAL = ThreadLocal.withInitial(() -> System.currentTimeMillis());

    public  static  final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public  static  long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
