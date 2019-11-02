package com.hhli.springbootstduy.serialize;

import lombok.Data;

/**
 * @author 李辉辉
 * @date 2019/11/2 18:24
 * @description
 */
@Data
public class TempFather {

    /**
     * 祖上家产
     */
    protected double money;

    public TempFather(){

    }

    public TempFather(double money){
        if(Double.compare(money, 0.0D)<0){
            throw  new IllegalArgumentException("祖上家产不能为负");
        }

        this.money = money;
    }
}
