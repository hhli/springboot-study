package com.hhli.springbootstduy.concurrent;


/**
 * @author 李辉辉
 * @date 2019-03-03 21:58
 * @description final引用逸出例子
 */
public class FinalReferenceEscapeExample {
    final int i;
    static   FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample(){
        i = 1;
        //引用逸出
        obj = this;
    }

    public static void reader(){
        new FinalReferenceEscapeExample();
    }

    public static void writer(){
        //FinalReferenceEscapeExample example = obj;
        //int b = example.i;
        //System.out.println("temp=" + example.i);
        if(obj != null){
            System.out.println("temp=" + obj.i);
        }else{
            System.out.println("obj is null");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(FinalReferenceEscapeExample::reader);
        Thread t2 = new Thread(FinalReferenceEscapeExample::writer);

        t1.start();
        t2.start();
    }
}
