package com.hhli.springbootstduy.stream;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李辉辉
 * @date 2019/12/15 16:35
 * @description
 */
public class MainLambda {
    //public static void main(String[] args) {
    //    new Thread(
    //            () -> System.out.println("Lambda Thread run()")
    //    ).start();;
    //}

    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };
    public static void main(String[] args) {
        //new MainLambda().r1.run();
        //new MainLambda().r2.run();

        Map<Integer, String> paramMap = new HashMap<>();
        paramMap.put(1, "one");
        paramMap.put(2, "two");
        paramMap.merge(1, "1", (v1, v2)-> v1 + v2);

        System.out.println(paramMap);
    }

    @Override
    public String toString() { return "Hello Hoolee"; }

}
