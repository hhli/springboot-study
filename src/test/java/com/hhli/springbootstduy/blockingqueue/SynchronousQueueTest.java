package com.hhli.springbootstduy.blockingqueue;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 李辉辉
 * @date 12/27/20 12:21 PM
 * @description SynchronousQueue测试
 */
public class SynchronousQueueTest {

    public static void main(@NotNull String[] args) throws InterruptedException {
        //SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);
        //
        //for (int i = 0; i < 10; i++) {
        //    final int temp = i;
        //    new Thread(()->{
        //        try {
        //            queue.put(temp);
        //            //System.out.println("输入" + temp);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    }).start();
        //}
        //
        //while (queue.isEmpty()){
        //    System.out.println("输出" + queue.take());
        //}
        //
        //List<String> strings = new ArrayList<>(8);
        //
        //List<String> temps = Collections.synchronizedList(strings);
        //
        //for (int i = 0; i < 10; i++) {
        //    new Thread(()->{
        //        strings.add(Thread.currentThread()getName() + ThreadLocalRandom.current().nextInt(0, 100));
        //        try {
        //            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 100));
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        strings.add(Thread.currentThread().getName() + ThreadLocalRandom.current().nextInt(0, 100));
        //    }).start();
        //}
        //
        //
        //while (true){
        //
        //}

        //System.out.println(2 >> 1);

        List<String> tempList = new ArrayList<>();
        tempList.add("1");
        tempList.add("2");
        tempList.add("3");
        //for (String s : tempList) {
        //    System.out.println("s");
        //    tempList.remove(s);
        //}

        //for (int i = 0; i < tempList.size(); i++) {
        //    System.out.println(tempList.get(i));
        //    tempList.remove(i);
        //}

        ListIterator<String> iterator = tempList.listIterator();
        if(iterator.hasNext()){
            iterator.next();
            iterator.set("111");
            iterator.add("222222");
        }

        System.out.println(tempList);
    }
}
