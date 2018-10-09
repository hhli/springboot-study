package com.hhli.springbootstduy.pattern.strategy;

/**
 * Created by hhli_yangyu on 2018/10/9.
 * @author hhli_yangyu
 * @summary
 */
public abstract class Strategy {
    /**
     *  计算折扣
     * @param basePrice
     * @return
     */
    public abstract double getDiscount(double basePrice);
}
