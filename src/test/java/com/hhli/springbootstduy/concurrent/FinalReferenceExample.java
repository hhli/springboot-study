package com.hhli.springbootstduy.concurrent;


/**
 * @author 李辉辉
 * @date 2019-03-03 21:39
 * @description 对final引用类型重排序的理解
 */
public class FinalReferenceExample {
    final  int[] intArray;
    static FinalReferenceExample obj;

    public FinalReferenceExample(){
        intArray = new int[1];
        intArray[0] = 1;
    }

    public  static  void  writeOne(){
        obj = new FinalReferenceExample();
    }

    public  static void writeTwo(){
        obj.intArray[0] = 2;
    }

    public  static  void reader(){
        if(obj != null){
            int temp1 = obj.intArray[0];
            System.out.println("temp1=" + temp1);

        }else {
            System.out.println("obj is null");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(FinalReferenceExample::writeOne);
        Thread t2 = new Thread(FinalReferenceExample::writeTwo);
        Thread t3 = new Thread(FinalReferenceExample::reader);

        t1.start();
        t2.start();
        t3.start();
    }
}
