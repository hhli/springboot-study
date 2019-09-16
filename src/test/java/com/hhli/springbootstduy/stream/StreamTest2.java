package com.hhli.springbootstduy.stream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李辉辉
 * @date 2019/7/19 8:40
 * @description stream测试
 */
public class StreamTest2 {

    public static void main(String[] args) {
        //Stream.of("merrily", "merrily", "test", "test").distinct().sorted().forEach(System.out::println);
        //
        //Object[] temp = Stream.iterate(1.0, p -> p * 2.0).peek(e->System.out.println("Fetching:" + e)).limit(20).toArray();
        //System.out.println(Arrays.toString(temp));

        //Stream.iterate(1.0, p -> p * 2.0).peek(e->System.out.println("Fetching:" + e));
        //
        //List<String> results = new ArrayList<>();
        //Stream.of("11").findFirst().ifPresent(System.out::println);
        //Stream.of("11").findFirst().ifPresent(results::add);
        //
        //Stream.of("11").findFirst().map(results::add);
        //
        //System.out.println(results);
        //
        //Optional.of("111");

        //System.out.println(Integer.MAX_VALUE);
        //int i = 1567740672;
        //System.out.println(Math.round(1567740625.0) == i);

        Map<String, String> tempMap = new HashMap<>(2);
        tempMap.put("1", "1");

        for (Map.Entry<String, String> tempEntry : tempMap.entrySet()) {
            System.out.println(tempEntry);
            tempMap.remove(tempEntry.getKey());
        }
    }
}
