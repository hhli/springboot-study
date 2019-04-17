package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 9:19
 * @description
 */
public class Context2 {
    //抽象策略
    private Strategy strategy = null;

    public Context2(Strategy strategy){
        this.strategy = strategy;
    }

    public void doAnything(){
        this.strategy.doSomething();
    }
}
