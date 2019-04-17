package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 8:47
 * @description 孙夫人断后
 */
public class BlockEnemy implements IStrategy{

    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
