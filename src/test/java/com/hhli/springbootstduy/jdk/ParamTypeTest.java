package com.hhli.springbootstduy.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/5/27 20:52
 * @description 泛型测试
 */
public class ParamTypeTest {

    public static void main(String[] args) {
        List<ArrayList<String>> tempList = new ArrayList<>();
    }

    public static <T> T getTest(){
        return  null;
    }

}
