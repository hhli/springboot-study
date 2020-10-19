package com.hhli.springbootstduy.function.part5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream<T>的抽象含义为一系列待处理的多个对象，类比Optional，
 * Stream对一系列对象定义一系列统一操作，
 * 在终止操作前中间操作并不会执行；
 * @author lizepu
 *
 */
public class AboutStream {
    /**
     * 初始化
     */
    void stmInit() {
        // 空Stream
        Stream<Object> empty = Stream.empty();
        
        // 用可枚举的已有对象构造一个有限流
        Stream<Integer> limitedStream = Stream.of(1,2,3);
        
        // 用迭代方式构造一个无限流 0,1,2,3...
        Stream<Integer> unlimitedStream = Stream.iterate(0, i -> i + 1);
        
        // 在无限流上增加限制
        Stream<Integer> subStream = unlimitedStream.limit(100);
        
        
        //但上述对Stream的构造在实际应用中并不多，从已有的Array或Collection组件得到Stream则更为常用：
        // 由List得到Stream
        List<String> strList = new ArrayList<>();
        Stream<String> strStream = strList.stream();
        
        // 由Set得到Stream
        Set<Long> longSet = new HashSet<>();
        Stream<Long> longStream = longSet.stream();
        
        // Map则常用entrySet得到流
        Map<Integer,String> map = new HashMap<>();
        Stream<Entry<Integer, String>> kvStream = map.entrySet().stream();
 
        // 数组构造，这里可以注意一下基本类型流的命名规则，这里有:
        // int stream
        IntStream intS = Arrays.stream(new int[] {1,2,3});
        // double stream
        DoubleStream doubleS = Arrays.stream(new double[] {1.,2.,3.});
        // String stream
        Stream<String> strS = Arrays.stream(new String[]{"a","1","2"});
        
        // 合并
        // 合并两个流 a b 
        Stream.concat(strS ,Arrays.stream(new String[] {"4","5","6"}));
    }
    
    /**
     * 变换
     */
    void stmTransmation() {
        // map
        trMap();
        // filter
        trFilter();
        
    }
    /**
     * Stream<T>.map 定义了对T的变换操作，此处可以传入一个Function<T,R> 将T变换为R；即Stream<T> 变为 Stream<R>;
     */
    void trMap() {
        // String stream
        Stream<String> strStream = Arrays.stream(new String[]{"0","1","2"});
        // map to Integer
        Stream<Integer> integerStream = strStream.map(Integer::valueOf);
    }
    
    /**
     * Stream<T>.filter 定义了一个对T的断言，此处传入一个Predicate<T>为T下一个判断，将满足断言条件为true的对象构造为一个新的Stream；
     */
    void trFilter() {
        // 过滤得到一个偶数流
        Stream<Integer> evenStream = Stream.iterate(0, i -> i + 1).filter(i -> i % 2 == 0);
        // 过滤得到一个字符串流
        Stream<String> strStream = Stream.of("123",1L,123.456)
                .filter(String.class::isInstance)
                .map(String.class::cast);
    }
    
    /**
     * Stream本身的含义是多个对象组成的流，因此一些变换操作是围绕着数量进行的：
     */
    void trSize() {
        // limit限制了流的数量（对于无限流而言）
        Stream<Integer> limitedStream = Stream.iterate(0, i -> i + 1).limit(100);
        
        // skip可以跳过若干个流的对象
        Stream<Integer> skiptedStream = limitedStream.skip(90);// 90,91,92...99
        
        // flatMap 映射为多个流并打平数据
        // 1 -> 1
        // 2 -> 1,2
        // 3 -> 1,2,3
        // integerStream: 1,1,2,1,2,3
        Stream<Integer> integerStream = Stream.of(1,2,3).flatMap(i -> Stream.iterate(1, j -> j + 1).limit(i));
        
        // sorted排序 sortedStream: 1,1,1,2,2,3 
        Stream<Integer> sortedStream = integerStream.sorted();
        
        // distinct去重 distinctStream: 1,2,3
        Stream<Integer> distinctStream = sortedStream.distinct();
    }
    
    void stmTerm() {
        // forEach 是常用终止操作，这里打印了所有对象
        Stream.iterate(0, i -> i + 1).limit(10).forEach(System.out::println);
        
        
        // collect 这里将Stream收集变为list
        List<Integer> list = Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList());
        // collect 亦可收集为Set
        Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toSet());
        // toArray 将Stream的对象变为数组，注意这里toArray入参为函数式接口IntFunction<Integer[]> 
        Integer[] arr = Stream.iterate(0, i -> i + 1).limit(10).toArray(Integer[]::new);
        
        
        // 将Stream变为map toMap需要定义两个关于Stream类型T的Function以决定map的key-value类型 请注意toMap的重载
        Map<Integer, Integer> map = Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toMap(Function.identity(), Function.identity()));
        
        
        // 分组聚合 这里按照基偶将流分裂为两个list 并放置于map中 请注意groupingBy方法的入参是一个Function
        // 0 -> [0,2,4,6,8]
        // 1 -> [1,3,5,7,9]
        Map<Integer, List<Integer>> groupByMap = Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.groupingBy(i -> i % 2));
        
        
        
        // 下面介绍一些列尝试合并整个Stream流对象得到一个值的功能
        // 统计流中对象的数量
        long count = Stream.iterate(0, i -> i + 1).limit(10).count();
        
        // 对流使用断言 allMatch即全部满足时返回true
        boolean allBiggerThanTen = Stream.iterate(0, i -> i + 1).limit(15).allMatch(i -> i > 10);
        
        // 对流使用断言 anyMatch即流中至少有一个对象满足时返回true
        boolean hasBiggerThanTen = Stream.iterate(0, i -> i + 1).limit(15).anyMatch(i -> i > 10);
        
        // reduce 常用操作之一，传入BinaryOperator<T>并对流对象进行迭代，最终合并为一个结果；由于Stream中可能为0个对象，故这里得到的结果为Optional（可有可无）
        // 这里是用reduce求和
        Optional<Integer> sum = Stream.iterate(0, i -> i + 1).reduce((i,j) -> i + j);
        
        // 得到第一个对象
        Optional<Integer> first = Stream.iterate(0, i -> i + 1).reduce((i,j) -> i);
        
        // 得到最后一个对象
        Optional<Integer> last = Stream.iterate(0, i -> i + 1).reduce((i,j) -> j);
        
        // 得到第一个对象（相对于上面reduce来讲更为正统方式)
        Optional<Integer> realFirst = Stream.iterate(0, i -> i + 1).findFirst();
        
        // 一个map+reduce，搞大数据的看了可能会比较亲切
        Stream.of("1","2","3").map(Integer::valueOf).reduce((x,y) -> x + y).ifPresent(System.out::println);// 打印6
        
        // 求最大，这里注意max的入参 Comparator<T>，已经被@FunctionalInterface所标记
        Optional<Integer> max = Stream.iterate(0, i -> i + 1).max(Integer::compareTo);
        
        // 求最小
        Optional<Integer> min = Stream.iterate(0, i -> i + 1).min(Integer::compareTo);
    }
}
