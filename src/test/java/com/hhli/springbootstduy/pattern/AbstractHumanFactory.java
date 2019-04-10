package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/9 22:42
 * @description 抽象人类创建工厂
 */
public abstract  class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
