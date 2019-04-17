package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 9:21
 * @description 高层模块
 */
public class StrategyClient {

    public static void main(String[] args) {
        //声明一个具体的策略
        Strategy strategy = new ConcreteStrategy1();
        //声明具体的上下文
        Context2 context = new Context2(strategy);
        //执行封装后的方法
        context.doAnything();

        System.out.println(Calculator.Sub.exec(1, 2));

    }
}
