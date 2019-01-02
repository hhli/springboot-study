package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/1/1 9:50
 * @description volidate使用测试
 */
public class VolidateTest {
    public static  int race = 0;

    private static final int THREAD_COUNT = 20;

    public  static  void increase(){
        race++;
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];

        for(int i=0; i<THREAD_COUNT; i++){
            threads[i] = new Thread(()->{
                for(int j=0;  j<10000; j++){
                    increase();
                }
            });
            threads[i].start();

        }


        //for(int i=0; i<THREAD_COUNT; i++){
        //    threads[i].join();
        //}

        while (Thread.activeCount() >1){
            //直接运行死循环
            //调试可以正常运行，为啥？？？
            Thread.yield();
        }

        System.out.println(race);
    }
}
