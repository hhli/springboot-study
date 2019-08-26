package com.hhli.springbootstduy.effective;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/8/25 16:49
 * @description 测试函数式接口异常
 */
public class FunctionalInterfaceWithException {

    public static void main(String[] args) {
        //InterfaceWithException temp = i->{throw  new Exception();}

        //List<Integer> intList = Arrays.asList(1, 2,  3);
        //intList.stream().map(i->i+1).forEach(System.out::println);
        //intList.stream().map(String::valueOf).flatMap(str->str.split("\\s+"));
        Stream.of(Operation.values()).flatMap(op->Stream.of(Operation.values())).collect(Collectors.toList()).forEach(System.out::println);
    }
}

@FunctionalInterface
interface  InterfaceWithException{
    void apply(int i);
}

