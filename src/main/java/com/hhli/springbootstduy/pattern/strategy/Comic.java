package com.hhli.springbootstduy.pattern.strategy;

/**
 * Created by hhli_yangyu on 2018/10/9.
 * @author hhli_yangyu
 * @summary
 */
public class Comic extends Book{

    public  Comic(double basePrice){
        super(basePrice);
    }

    @Override
    public void show() {
        System.out.println("The Comic Book is "+ getPrice());
    }
}
