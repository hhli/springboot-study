package com.hhli.springbootstduy.thread;


/**
 * @author 李辉辉
 * @date 2019-03-03 16:42
 * @description
 */
public class VolatileExample {
    int  a = 0;
    volatile  boolean flag = Boolean.FALSE;

    public  void writer(){
        a = 1;
        flag = true;
    }

    public  void reader(){
        if(flag){
            System.out.println(a);
        }else {
            System.out.println("done");
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();

        Thread readThread = new Thread(()->{
            example.reader();
        });

        Thread writeThread = new Thread(()->{
            example.writer();
        });


        writeThread.start();
        readThread.start();
    }
}
