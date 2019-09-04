package com.hhli.springbootstduy.stream;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        //List<Integer> intList = Stream.iterate(0, n->n+1).limit(100).collect(Collectors.toList());

        //System.out.println(intList);

        //InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
        //threadLocal.set(111);
        //System.out.println("哈哈：" +threadLocal.get());
        //
        //intList.parallelStream().map(t->{
        //    if(Objects.isNull(threadLocal.get())){
        //        System.out.println(Thread.currentThread().getName());
        //    }
        //
        //    return  t;
        //    //if(Math.random() * 100 % 83 == 0){
        //    //    throw new RuntimeException("test");
        //    //}
        //});


        //int[] temp = new int[0];
        //System.out.println(Arrays.toString(temp));

        List<String> tempList = Arrays.asList("101", "一零二", "一零三", "1010", "104", "一零四");

        Pattern p = Pattern.compile("\\d+");

        tempList.sort((o1, o2) -> {
            Integer number1 = null;
            Integer number2 = null;
            Matcher m = p.matcher(o1);
            if (m.lookingAt()) {
                number1 = Integer.parseInt(m.group());
            }

            m = p.matcher(o2);
            if (m.lookingAt()) {
                number2 = Integer.parseInt(m.group());
            }

            int result ;
            if (Objects.nonNull(number1) && Objects.nonNull(number2)) {
                result=  number1.compareTo(number2);
            }else if(Objects.isNull(number1) && Objects.nonNull(number2)){
                result = 1;
            }else if(Objects.nonNull(number1)){
                result =   -1;
            }else{
                result =  o1.compareTo(o2);
            }

            System.out.printf("%s %s %d\n", o1, o2, result);

            return result;
        });

        //排序前：101, 102, 103, 1010, 104, 110
        //排序后：101, 1010, 102, 103, 104, 110
        System.out.println(tempList);
    }
}
