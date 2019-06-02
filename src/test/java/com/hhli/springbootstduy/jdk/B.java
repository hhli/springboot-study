package com.hhli.springbootstduy.jdk;

import java.util.*;

/**
 * @author 李辉辉
 * @date 2018/11/23 8:55
 * @description
 */
public class B {

    public static void main(String[] args) {
        //List<Long> idList = new ArrayList<>();
        //idList.add(1L);
        //idList.add(2L);
        //System.out.println(idList.toString().replace("[", "").replace("]", ""));
        //
        //EnumSet<WEEKDAY> always = EnumSet.allOf(WEEKDAY.class);
        //System.out.println(always);
        //
        //List<Object> objects = Collections.nCopies(10, new Object());

        ArrayList<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");
        List<String> stringList = Collections.checkedList(test, String.class);

        List raw =  stringList;
        raw.add(new Date());


        System.out.println("done~~~~");
    }
}


class  A{

}

enum WEEKDAY{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}