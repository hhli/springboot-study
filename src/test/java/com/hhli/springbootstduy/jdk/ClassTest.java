package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019/5/20 9:28
 * @description  反射测试
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class tempClass = Class.forName("org.springframework.jmx.support.ConnectorServerFactoryBean");

        System.out.println(tempClass.getDeclaredMethods()[0]);
    }
}
