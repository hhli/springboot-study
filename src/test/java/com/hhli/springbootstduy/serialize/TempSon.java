package com.hhli.springbootstduy.serialize;

import lombok.Data;
import lombok.ToString;

/**
 * @author 李辉辉
 * @date 2019/11/2 17:17
 * @description
 */
@Data
@ToString(callSuper = true)
public class TempSon extends Temp{

    /**
     * 兴趣
     */
    private String hobby;

    public  TempSon(double money, int age, int weight, String hobby){
        super(money, age, weight);
        this.hobby = hobby;
    }
}
