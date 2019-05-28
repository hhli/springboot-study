package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019-05-20 19:18
 * @description
 */
public class StackTest {
    private static  Integer  i = 0;
    private static  final StringBuilder TEMP = new StringBuilder();

    public static void main(String[] args) {
        try{
            test();
        }catch (Exception e){

        }
    }

    public static  void test(){
        i++;
        System.out.println(i);
        test();
        String temp1 = TEMP.toString();
        TEMP.append("{\"list\":").append(temp1).append(", \"name\":\"11111\", \"age\":11111111}");
        System.out.println(TEMP.toString());
        System.out.println(TEMP.length());
    }
}
