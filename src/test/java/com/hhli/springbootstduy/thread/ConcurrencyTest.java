package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/2/13 9:32
 * @description 测试开启线程与直接运行的差距
 */
public class ConcurrencyTest {
    public static  final long[] countArray = {10000, 100000, 1000000, 10000000, 100000000};

    public static void main(String[] args) throws InterruptedException {
        for (long l : countArray) {
            concurrency(l);
            serial(l);
        }
    }

    public static void concurrency(long count) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for(long i =0; i<count; i++){
                a += 5;
            }
        });
        thread.start();

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;

        thread.join();
        System.out.println("concurrency:" + time + "ms, b=" + b);
    }

    public static  void serial(long count){
        long start = System.currentTimeMillis();

        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;
        for (long l = 0; l < count; l++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, b=" + b);
    }
}
