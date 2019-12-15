package com.hhli.springbootstduy.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/12/15 10:27
 * @description 缩减测试
 */
public class ReduceTest {

    public static void main(String[] args) {
        //List<String> companyList = Arrays.asList("facebook", "google", "alibaba");
        //System.out.println(companyList.stream().reduce(";", String::concat));
        //
        //System.out.println(companyList.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
        //
        //companyList.stream().collect(Collectors.toSet());


        //List<Integer> tempList = Arrays.asList(1, 2, 3, 4, 5);
        //Optional<Integer> reduce = tempList.stream().reduce(Integer::sum);
        //reduce.ifPresent(System.out::println);
        //
        //System.out.println(tempList.stream().mapToInt(Integer::intValue).sum());
        //
        //System.out.println(  IntStream.of(1, 2, 3, 4, 5).sum());

        //Runnable runnable = ()-> System.out.println("hello lambda");
        //ActionListener listener = event-> System.out.println("button clicked");
        //Runnable multiline = ()->{
        //    System.out.println("hi");
        //    System.out.println("lee");
        //};
        //
        //BinaryOperator<Long> add = (Long x, Long y)->x+y;
        //BinaryOperator<Long> addImplicit = (x, y)->x+y;
        //ConsumerInterface<String> t = System.out::println;

        Stream<String> stream = Stream.of("I", "love", "you", "too");
        System.out.println( stream.reduce((s1, s2)->s1.length()>s2.length() ?s1:s2).get());

        stream = Stream.of("I", "love", "you", "too");
        Set<String> tempSet = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(tempSet);
        //System.out.println(stream.collect(Collectors.toCollection(HashSet::new)));

        stream = Stream.of("I", "love", "you", "too");
        System.out.println(stream.collect(Collectors.joining(",", "{", "}")));
    }
}
