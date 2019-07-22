package com.hhli.springbootstduy.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019-07-19 17:21
 * @description 流式测试
 */
public class StreamTest3 {

    public static void main(String[] args) {
        //List<String> words = Lists.newArrayList();
        //words.toArray(new String[0]);
        //
        //List<String> strList = Arrays.asList("1", "2", "3");
        //System.out.println(String.join(";", strList));

        List<Integer> intList = Stream.iterate(0, n->n+1).limit(1000).collect(Collectors.toList());

        System.out.println(intList);

        InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set(111);
        System.out.println("111" +threadLocal.get());
        intList.parallelStream().forEach(t->{
            try{
                Thread.sleep(10);
                if(Objects.isNull(threadLocal.get())){
                    System.out.println(Thread.currentThread().getName());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }
}
