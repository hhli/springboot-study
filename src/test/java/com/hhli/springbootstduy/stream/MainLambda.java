package com.hhli.springbootstduy.stream;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 李辉辉
 * @date 2019/12/15 16:35
 * @description
 */
public class MainLambda {
    public static void main(String[] args) {
    //    new Thread(
    //            () -> System.out.println("Lambda Thread run()")
    //    ).start();;
    //}

    //Runnable r1 = () -> { System.out.println(this); };
    //Runnable r2 = () -> { System.out.println(toString()); };
    //public static void main(String[] args) {
    //    //new MainLambda().r1.run();
    //    //new MainLambda().r2.run();
    //
    //    Map<Integer, String> paramMap = new HashMap<>();
    //    paramMap.put(1, "one");
    //    paramMap.put(2, "two");
    //    paramMap.merge(1, "1", (v1, v2)-> v1 + v2);
    //
    //    System.out.println(paramMap);
    //}
    //
    //@Override
    //public String toString() { return "Hello Hoolee"; }

        Calendar calendar = Calendar.getInstance();
        // 2014-12-26
        calendar.set(2010, Calendar.NOVEMBER, 26);
        Date strDate1 = calendar.getTime();
        SimpleDateFormat f1 = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("Result for YYYY: " + f1.format(strDate1));
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Result for yyyy: " + f2.format(strDate1));
    }

}
