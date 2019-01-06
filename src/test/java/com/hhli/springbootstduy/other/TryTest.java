package com.hhli.springbootstduy.other;

/**
 * @author 李辉辉
 * @date 2019/1/5 21:43
 * @description try以及return测试
 */
public class TryTest {

    public static void main(String[] args) {
        //System.out.println(test1());
        //System.out.println(test2());
        //System.out.println(test3());
        System.out.println(test().num);
        //System.out.println(test4());
    }


    private static int test1(){
        int num = 10;
        try{
            System.out.println("try");
            return num += 80;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
        }

        return num;
    }


    private static int test2(){
        int num = 10;
        try{
            System.out.println("try");
            return num += 80;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = 100;
            return num;
        }
    }


    private static int test3(){
        int num = 10;
        try{
            System.out.println("try");
            return num;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num > 20){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = 100;
        }
        return num;
    }


    private static Num test(){
        Num number = new Num();
        number.num = 1000;
        try{
            System.out.println("try");
            return number;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (number.num > 20){
                System.out.println("number.num>20 : " + number.num);
            }
            System.out.println("finally");
            number = new Num();
            number.num = 200;
        }
        return number;
    }

    private static  String test4(){
        String num = "10";
        try{
            System.out.println("try");
            return num;
        }catch(Exception e){
            System.out.println("error");
        }finally{
            if (num.compareTo("20") > 0){
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = "100";
        }
        return num;
    }
}

class  Num{
    public int num = 10;
}
