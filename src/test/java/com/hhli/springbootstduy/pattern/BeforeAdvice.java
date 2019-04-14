package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/14 15:03
 * @description
 */
public class BeforeAdvice implements IAdvice{

    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了~~");
    }
}
