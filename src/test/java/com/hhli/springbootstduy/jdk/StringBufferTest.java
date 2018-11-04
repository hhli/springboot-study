package com.hhli.springbootstduy.jdk;

import java.io.Console;

/**
 * @author 李辉辉
 * @date 2018/11/4 16:56
 * @description 
 */
public class StringBufferTest {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);

        ////get first input
        //System.out.print("hi, what's your name?");
        //String name = in.nextLine();
        //
        ////get second input
        //System.out.print("how old are you?");
        //int age = in.nextInt();
        //
        ////display output on console
        //System.out.println("Hello, " + name + ". Next year, you will'be " + (age + 1));

        Console console = System.console();
        String userName = console.readLine("User name: ");
        char[] password = console.readPassword("Password: ");
        System.out.println(userName + ":" + new String(password));
    }
}
