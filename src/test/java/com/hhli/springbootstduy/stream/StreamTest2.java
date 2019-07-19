package com.hhli.springbootstduy.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

        List<String> results = new ArrayList<>();
        Stream.of("11").findFirst().ifPresent(System.out::println);
        Stream.of("11").findFirst().ifPresent(results::add);

        Stream.of("11").findFirst().map(results::add);

        System.out.println(results);

        Optional.of("111");
    }
}
