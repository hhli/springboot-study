package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 9:15
 * @description 具体策略2
 */
public class ConcreteStrategy2 implements Strategy{

    @Override
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }
}
