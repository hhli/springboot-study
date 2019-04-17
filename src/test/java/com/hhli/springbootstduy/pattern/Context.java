package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 8:51
 * @description 锦囊
 */
public class Context {
    //构造函数，使用哪个妙计
    private IStrategy strategy;

    public Context(IStrategy strategy){
        this.strategy = strategy;
    }

    //使用计谋，我要出招了
    public void operate(){
        this.strategy.operate();
    }
}
