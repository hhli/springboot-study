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

    private static final long serialVersionUID = 1203690938440132417L;

    /**
     * 兴趣
     */
    private String hobby;

    public  TempSon(double money, int age, int weight, String hobby){
        super(money, age, weight);
        this.hobby = hobby;
    }


    public TempSon(){
        super(0.0d, 10, 10);
    }
}
