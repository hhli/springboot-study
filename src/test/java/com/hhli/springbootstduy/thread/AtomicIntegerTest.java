package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2018/11/24 16:06
 * @description 整型原子类测试
 */
public class AtomicIntegerTest {
      //static AtomicInteger count = new AtomicInteger();
    //static Integer count = new Integer(0);
    //static MyselfAtomicInteger count = new MyselfAtomicInteger();
    static MyselfAtomicInteger count = new MyselfAtomicInteger(100000);
    public static void main(String[] args) {
        //
        //ExecutorService executor = Executors.newFixedThreadPool(5);
        //
        //for(int k =0; k<100; k++){
        //    executor.submit(() -> {
        //        for(int i = 0; i<1000; i++){
        //            //System.out.println(count.incrementAndGet());
        //            //System.out.println(count++);
        //            System.out.println(count.decrementAndGet());
        //        }
        //    });
        //}
        //
        //System.out.println("result  of accumulated sun = " + count);
        //executor.shutdown();
        //
        //System.out.println("end~~~");



        Thread t = new Thread(()->{
            throw  new RuntimeException("test");
        });
        t.start();

        System.out.println("hh");
    }
}
