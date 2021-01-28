package com.hhli.springbootstduy.collection;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 1/25/21 4:26 PM
 * @description 多线程遍历测试
 */
public class SpliteratorTest {

    public static void main(String[] args) throws InterruptedException {
        //List<Integer> inters = Lists.newArrayList(1, 2, 8, 9, 10, 5,6, 4, 3, 7);
        //Spliterator<Integer> s0 = inters.spliterator();
        //Spliterator<Integer> s1 = s0.trySplit();
        //Spliterator<Integer> s2 = s0.trySplit();
        //
        //s0.forEachRemaining(t->{
        //    System.out.println("s0:" + t);
        //});
        //System.out.println("================");
        //
        //s1.forEachRemaining(t->{
        //    System.out.println("s1:" + t);
        //});
        //System.out.println("================");
        //
        //
        //s2.forEachRemaining(t->{
        //    System.out.println("s2:" + t);
        //});
        //System.out.println("================");
        //
        //
        //inters.forEach(System.out::println);

        //Arrays.stream(new int[]{1, 2,3 }).forEach(System.out::println);
        //
        //LinkedList<String> t1 = new LinkedList<>();
        //LinkedList<String> t2 = new LinkedList<>();
        //
        //for (int i=t1.size()-1,j=t2.size()-1; i>=0 && j>=0; i--,j-- ){
        //    if(t1.get(i).equals(t2.get(j))){
        //        return ;
        //    }
        //}

        for (int i = 0; i < 100; i++) {
            CopyOnWriteArrayList<String> tempList = new CopyOnWriteArrayList<>();
            tempList.add("1");
            tempList.add("2");

            Thread t1 = new Thread(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
                    tempList.remove(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t2 = new Thread(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 1000));
                    System.out.println("index0=" + tempList.get(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
            t2.start();

            t2.join();
            t1.join();
        }

        System.out.println("done~~~");

    }
}
