package com.hhli.springbootstduy.concurrent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李辉辉
 * @date 2019/3/12 22:45
 * @description 连接池测试
 */
public class ConnectionTest {
    static  ConnectionPool pool = new ConnectionPool(10);
    //保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main线程将会等待所有ConnectionRunner结束后才能继续执行
    static  CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        //线程数据，可以修改线程数量进行观察
        //int threadCount = 10;
        //int threadCount = 20;
        //int threadCount = 30;
        int threadCount = 40;
        //int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count  = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread" + i);
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " +  (threadCount * count));
        System.out.println("got connection：" + got);
        System.out.println("not got connection：" + notGot);
    }

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long start = System.currentTimeMillis();
            while (count > 0){
                //从线程池获取链接， 如果100ms内无法获取到，将会返回null
                // 分别统计连接池获取的数据got和未获取到的数量notGot
                try {
                    Connection  connection = pool.fetchConnection(100L);

                    if(connection != null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                            System.out.println("Cost time:" + (System.currentTimeMillis()-start) + "ms");
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    count --;
                }
            }

            end.countDown();
        }
    }

}
