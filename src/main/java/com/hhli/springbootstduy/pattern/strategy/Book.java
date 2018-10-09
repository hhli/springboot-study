package com.hhli.springbootstduy.pattern.strategy;

/**
 * Created by hhli_yangyu on 2018/10/9.
 * @author hhli_yangyu
 * @summary
 */
public abstract  class Book {
    /**
     * 原价
     */
    protected  double basePrice = 0.0;

    /**
     * 策略
     */
    protected Strategy strategy;

    public Book(double basePrice){
        this.basePrice = basePrice;
    }

    public double getPrice() {
        return strategy.getDiscount(basePrice);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 每类书都有自己的展示方式
     */
    public abstract  void show();
}
