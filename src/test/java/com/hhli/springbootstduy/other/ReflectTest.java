package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.model.hdic.BasePojo;
import com.hhli.springbootstduy.model.hdic.Resblock;

import java.lang.reflect.Field;

/**
 * @author 李辉辉
 * @date 2018/12/17 17:02
 * @description
 */
public class ReflectTest {

    public static void main(String[] args) {
        BasePojo resblock = new Resblock();
        for (Field field : resblock.getClass().getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}
