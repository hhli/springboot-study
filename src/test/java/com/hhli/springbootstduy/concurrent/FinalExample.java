package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2019-03-03 21:16
 * @description 对final基本类型变量重排序的理解
 */
public class FinalExample {
    int i ;
    final  int j;
    static  FinalExample example;

    public FinalExample(){
        i = 1;
        j = 2;
    }

    public  static void reader(){
        example = new FinalExample();

        //System.out.println("a=" + example.i + ",b=" + example.j);

    }

    public  static  void writer(){
        FinalExample obj = example;
        int a = obj.i;
        int b = obj.j;

        System.out.println("a=" + a + ",b=" + b);
    }

    public static void main(String[] args) {
     Thread readThread = new Thread(FinalExample::reader);

     Thread writeThread = new Thread(FinalExample::writer);

     readThread.start();
     writeThread.start();
    }

}
