package com.hhli.springbootstduy.effective;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author 李辉辉
 * @date 2019/8/25 13:21
 * @description 闭包测试
 */
public class MyJavaCounter {
    //private int value;
    //
    //public MyJavaCounter(int value){
    //    this.value = value;
    //}
    //
    //public int increment(){
    //    return  value++;
    //}

    public static void main(String[] args) {
        Map<String, Supplier> counter = createCounter(42);
        System.out.println(counter.get("val").get());
        System.out.println(counter.get("inc").get());
        System.out.println(counter.get("val").get());
    }

    private static class MyResource{
        private int value;
        public MyResource(int initValue){
            this.value = initValue;
        }
    }

    public static Map<String, Supplier> createCounter(int initValue){
        MyResource closure = new MyResource(initValue);
        Map<String, Supplier> counter = new HashMap<>();
        counter.put("val", ()->closure.value);
        counter.put("inc", ()->closure.value++);
        return counter;
    }
}
