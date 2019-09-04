package com.hhli.springbootstduy.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/6/2 17:19
 * @description ArrayList测试
 */
public class ArrayListTest {

    public static void main(String[] args) {
        //ArrayList<String> strList = new ArrayList<>();
        //strList.add("1");
        //strList.add("2");
        //strList.add("3");
        //strList.removeAll(Arrst("1", "4"));
        //
        //List<String> tempList = Arrays.asList("111", "2222");
        //tempList.set(0, "aaaa");
        //System.out.println(tempList);

        //List<String> sourceHouses = new ArrayList<>();
        //sourceHouses.add("1");
        //sourceHouses.add("2");
        //sourceHouses.add("3");
        //sourceHouses.add("4");
        //sourceHouses.add("5");
        //
        //List<String> targetHouses = new ArrayList<>();
        //targetHouses.add("1");
        //targetHouses.add("2");
        //targetHouses.add("3");
        //targetHouses.add("4");
        //
        //if(sourceHouses.size() > targetHouses.size()){
        //    sourceHouses.subList(targetHouses.size(), sourceHouses.size()).clear();
        //}else if(sourceHouses.size() < targetHouses.size()){
        //    targetHouses.subList(sourceHouses.size(), targetHouses.size()).clear();
        //}
        //
        //System.out.println("sources:" + sourceHouses);
        //System.out.println("targets:" + targetHouses);

        List<Integer> tempList = new ArrayList<>();
        tempList.add(1);
        int i = 1;
        tempList.remove(0);

    }
}
