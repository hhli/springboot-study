package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2020-02-02 20:46
 * @description
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    public  static void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end(){
       return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(1);
        System.out.println("Cost: " + Profiler.end() + " mills.");
    }
}
