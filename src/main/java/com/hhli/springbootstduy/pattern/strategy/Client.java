package com.hhli.springbootstduy.pattern.strategy;

/**
 * Created by hhli_yangyu on 2018/10/9.
 * @author hhli_yangyu
 * @summary 客户端调用
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
