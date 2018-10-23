package com.hhli.springbootstduy.jdk;

/**
 * Created by hhli_yangyu on 2018/10/23.
 *
 * @author hhli_yangyu
 * @summary
 */
public class WelCome {
    public static void main(String[] args) {
        String[] greeting = new String[3];
        greeting[0] = "Welcome to core java";
        greeting[1] = "by Cay Horstmann";
        greeting[2] = "and Gray Cornell";

        for(String g : greeting){
            System.out.println(g);
        }
    }
}
