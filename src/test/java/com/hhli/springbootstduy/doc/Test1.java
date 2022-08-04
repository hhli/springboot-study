package com.hhli.springbootstduy.doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @author 李辉辉
 * @date 2019/5/13 22:40
 * @description test1
 */
public class Test1 {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  id  the initial capacity of the list
     * @param name the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Test1(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        //HashMap<Integer, String> code2Name = new HashMap<>(64);
        //
        //List<Thread> threads = new ArrayList<>();
        //for (int i = 0; i < 5; i++) {
        //    Thread t1 = new Thread(()->{
        //        for (int j = 0; j < 1000; j++) {
        //            code2Name.put(ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE), "1");
        //        }
        //    });
        //
        //    threads.add(t1);
        //    t1.start();
        //}
        //
        //for (Thread thread : threads) {
        //    thread.join();
        //}
        //
        //System.out.println(code2Name.size());

        //LinkedHashMap<Integer, String> code2Name = new LinkedHashMap<>(16, 0.75F, true);
        //code2Name.put(null, null);
        //code2Name.put(2, "2");
        //
        //for (Integer integer : code2Name.keySet()) {
        //    System.out.println(integer + ":" + code2Name.get(integer));
        //}

        //System.out.println((1<<16)-1);
        //System.out.println(resizeStamp(16) - (1>>>16));
        //
        //System.out.println(16<<1);

        //Thread t1 = new Thread(()->{
        //    System.out.println("111");
        //    LockSupport.park();
        //});
        //
        //t1.start();
        //
        //LockSupport.unpark(t1);
        //
        //System.out.println("done");

        //System.out.println(Thread.currentThread().isInterrupted());
        //System.out.println(Thread.interrupted());
        //System.out.println(Thread.currentThread().isInterrupted());

        //ReentrantLock lock = new ReentrantLock();
        //try{
        //    lock.lock();
        //}finally {
        //    lock.unlock();
        //}
        //ExecutorService executorService = Executors.newFixedThreadPool(1);
        //
        //for (int i = 0; i < 5; i++) {
        //    final  int temp = i;
        //    executorService.execute(()->{
        //        System.out.println(5/temp);
        //    });
        //}
        //
        //executorService.shutdown();

        //IntStream.range(0, 4).forEach(System.out::println);
        //
        //Collector<String, StringJoiner, String> personNameCollector =
        //        Collector.of(
        //                () -> new StringJoiner(" | "),          // supplier 供应器
        //                (j, p) -> j.add(p.toUpperCase()),  // accumulator 累加器
        //                StringJoiner::merge,               // combiner 组合器
        //                StringJoiner::toString);                // finisher 终止器
        //
        //String names = Stream.of("a", "b").collect(personNameCollector);
        //
        //System.out.println(names);
        //
        //
        //System.out.println(Stream.of("1", "2").collect(Collectors.toList()));

        //Stream.of("1", "2").peek(System.out::println).collect(Collectors.toList());

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            double lng = ThreadLocalRandom.current().nextDouble(0, 180);
            double lat = ThreadLocalRandom.current().nextDouble(0, 90);

            strList.add(lng + " " + lat);
        }

        StringBuilder sb = new StringBuilder("insert into t_geo_test(`module_key`, `points`) values ('test', '");
        sb.append(String.join(",", strList));
        sb.append("')");

        List<int[]> ints = Arrays.asList(new int[] {1, 2});
        System.out.println(sb);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> temps = new ArrayList<>(nums1.length + nums2.length);
        for(int i : nums1){
            temps.add(i);
        }

        for(int i : nums2){
            temps.add(i);
        }

        temps.sort(Comparator.comparingInt(o -> o));
        int size = temps.size();

        return  size%2==0 ? (temps.get((size+1)/2) +temps.get((size-1)/2))/2.0 : temps.get((size+1)/2);
    }
    private static final int tableSizeFor(int c) {
        System.out.println(c);
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 16) ? 16 : n + 1;
    }

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (15));
    }
}
