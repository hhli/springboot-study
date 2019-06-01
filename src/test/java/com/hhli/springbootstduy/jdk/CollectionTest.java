package com.hhli.springbootstduy.jdk;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 李辉辉
 * @date 2019/5/29 22:03
 * @description 集合测试
 */
public class CollectionTest {

    public static void main(String[] args) {
        //List<Integer> tempList = Lists.newArrayList(1, 2, 3);
        //List<Integer> tempList2 = Lists.newArrayList(1, 2);
        //if(tempList.retainAll(tempList2)){
        //    System.out.println(tempList);
        //}
        //
        //LinkedList<String> testList = new LinkedList<>();
        //testList.listIterator();

        List<String> strList = new ArrayList<>();
        strList.add("1");
        ListIterator<String> iter1 = strList.listIterator();
        ListIterator<String> iter2 = strList.listIterator();
        iter1.next();
        iter1.remove();
        iter2.next();
    }


}
