package com.hhli.springbootstduy.effective;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 李辉辉
 * @date 2019/8/22 8:31
 * @description 可变类型测试
 */
public class VariableParameterTest {

    public static void main(String[] args) {
        //String[] attribute = pickTwo("Good", "Fast", "Cheap");
        //System.out.println(Arrays.toString(attribute));
        System.out.printf("%d %n", 1111);
    }

    static  <T> T[] toArray(T... args){
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0: return toArray(a, b);
            case 1: return  toArray(a, c);
            case 2: return  toArray(b, c);
        }
        throw  new AssertionError();
    }
}
