package com.hhli.springbootstduy.pattern.strategy;

/**
 * Created by hhli_yangyu on 2018/10/9.
 * @author hhli_yangyu
 * @summary
 */
public class ComicStrategy extends Strategy{

    @Override
    public double getDiscount(double basePrice) {
        return 0.6*basePrice;
    }
}
