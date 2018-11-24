package com.hhli.springbootstduy.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2018/11/23 8:55
 * @description
 */
public class B {

    public static void main(String[] args) {
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);
        System.out.println(idList.toString().replace("[", "").replace("]", ""));
    }
}


class  A{

}