package com.hhli.springbootstduy.io;

import lombok.Data;

/**
 * @author 李辉辉
 * @date 2019/7/21 19:34
 * @description
 */
@Data
public class TestSerializeFather {

    private int age;

    public TestSerializeFather(int age){
        this.age = age;
    }
}
