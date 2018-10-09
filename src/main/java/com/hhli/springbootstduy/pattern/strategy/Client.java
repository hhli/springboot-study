package com.hhli.springbootstduy.pattern.strategy;

/**
 * Created by hhli_yangyu on 2018/10/9.
 * @author hhli_yangyu
 * @summary 客户端调用
 * 1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
一个系统需要动态地在几种算法中选择一种。
2、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
3、不希望客户端知道复杂的、与算法相关的数据结构，在具体策略类中封装算法和相关的数据结构，提高算法的保密性与安全性。
 */
public class Client {
    public static void main(String[] args) {
        Book book = new Comic(12.3);
        Strategy strategy = new ComicStrategy();
        //设置采用何种策略
        book.setStrategy(strategy);
        book.show();
    }
}
