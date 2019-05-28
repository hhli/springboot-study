package com.hhli.springbootstduy.jdk;

import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2019/5/26 15:26
 * @description
 */
public class StackTraceTest {

    /**
     * compute the factorial of num
     * @param n n!= 1 * 2 * 3 *.....n
     * @return
     */
    public  static int factorial(int n){
        System.out.println("factorial(" + n + ")");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement frame : frames) {
            System.out.println(frame);
        }
        int r;
        if(n<1){
            r =1;
        } else{
          r =  n * factorial(n-1);
        }

        System.out.println("return " + r);

        return  n;
    }

    /**
     *  斐波那契递归
     * @param n
     * @return
     */
    public static int factWithRecursive(int n){
        if(n<=1) {
            return  1;
        }
        else {
            return factWithRecursive(n-1) + factWithRecursive(n-2);
        }
    }

    public static  int factWithoutRecursive(int n){
        int[] a = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if(i<=1){
                a[i] = 1;
            }else{
                a[i] = a[i-1] +a[i-2];
            }
        }

        return  a[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("enter n:");
        int n = in.nextInt();
        //
        //factorial(n);
        long start = System.currentTimeMillis();
        int a1 = factWithRecursive(n);
        long end = System.currentTimeMillis();

        System.out.println("waste time " + (end - start) + "ms");
        System.out.println("factWithRecursive(" + n + ")=" + a1);

        start = System.currentTimeMillis();
        int a2 = factWithoutRecursive(n);
        end = System.currentTimeMillis();

        System.out.println("waste time " + (end - start) + "ms");
        System.out.println("factWithoutRecursive(" + n + ")=" + a2);
    }
}
