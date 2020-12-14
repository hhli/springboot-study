package com.hhli.springbootstduy.spring;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 李辉辉
 * @date 2020-12-08 14:40
 * @description beandefination测试
 */
public class BeanDefinationTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("userName", "javaboy");
        pvs.add("address", "www.javaboy.org");

        RootBeanDefinition definition = new RootBeanDefinition(User.class, null, pvs);
        ctx.registerBeanDefinition("user", definition);
        ctx.refresh();

        User user = ctx.getBean(User.class);

        System.out.println(user);
    }
}
