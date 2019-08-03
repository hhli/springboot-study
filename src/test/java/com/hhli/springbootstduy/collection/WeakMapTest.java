package com.hhli.springbootstduy.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author 李辉辉
 * @date 2019/8/3 16:56
 * @description WeakHashMap测试
 */
public class WeakMapTest {

    public static void main(String[] args) {
        Map<String, String> weakMap = new WeakHashMap<>();
        Map<String, String> tempMap = new HashMap<>();

        String key = new String("test");
        weakMap.put(key, "1");
        //tempMap.put(key, "1");
        System.out.println("weakMap=" + weakMap);
        //System.out.println("tempMap=" + tempMap);

        key = null;
        System.gc();
        //for (int i = 0; i < 10; i++) {
        //    System.gc();
        //}


        System.out.println("weakMap=" + weakMap);
        //System.out.println("tempMap=" + tempMap);
    }
}
