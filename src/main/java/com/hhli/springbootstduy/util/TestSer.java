package com.hhli.springbootstduy.util;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestSer implements Externalizable {

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> strList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            String s = String.valueOf(i);
            new Thread(()->strList.add(s)).start();
        }

        strList.forEach(System.out::println);

        LinkedHashMap<String, String>  paramMap = new LinkedHashMap<>();
        paramMap.put("1", "1");
    }
}
