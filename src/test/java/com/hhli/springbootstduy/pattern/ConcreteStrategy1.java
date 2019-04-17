package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 9:13
 * @description 具体策略1
 */
public class ConcreteStrategy1 implements Strategy{

    @Override
    public void doSomething() {
        System.out.println("具体策略1的运算法则");
    }
}
