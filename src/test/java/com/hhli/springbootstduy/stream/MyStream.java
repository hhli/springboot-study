package com.hhli.springbootstduy.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/12/15 16:15
 * @description
 */
public class MyStream<T> {
    private List<T> list;

    public void myForeach(ConsumerInterface<T> consumerInterface){
        for (T t : list) {
            consumerInterface.accept(t);
        }
    }

    public static void main(String[] args) {
        MyStream<String> stream = new MyStream<>();
        stream.myForeach(System.out::println);
    }
}
