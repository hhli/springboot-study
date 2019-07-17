package com.hhli.springbootstduy.jdk;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.AbstractList;

/**
 * @author 李辉辉
 * @date 2019/6/18 8:52
 * @description 数组列表测试
 */
public class ArrayListTest {

    public static void main(String[] args) {
        //int x = Integer.MAX_VALUE /3 * 2 ;
        //int temp = x + x>>1;
        //System.out.println(temp);

        Method[] methods = AbstractList.class.getMethods();
        for (Method method : methods) {
            if(Modifier.isAbstract(method.getModifiers())){
                System.out.println(method.getName());
            }
        }
    }
}
