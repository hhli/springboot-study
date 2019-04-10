package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/9 22:47
 * @description 人类创建工厂
 */
public class HumanFactory extends AbstractHumanFactory{

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        T human = null;
        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            System.out.println("人种生成错误" + e);
        } catch (IllegalAccessException e) {
            System.out.println("人种生成错误" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("人种生成错误" + e);

        }

        return human;
    }
}
