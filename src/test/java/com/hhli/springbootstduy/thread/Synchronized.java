package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2020/1/29 12:08
 * @description
 */
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class){

        }
        m();
    }

    public static  synchronized void m(){

    }
}
