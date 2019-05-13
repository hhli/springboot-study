package com.hhli.springbootstduy.jdk;

import java.text.NumberFormat;

/**
 * @author 李辉辉
 * @date 2018/11/5 8:45
 * @description 数组测试
 */
public class ArrayTest {

    public static void main(String[] args) {
        //int[] a1 = new int[]{1,2,3,4};
        //int[] a2 = {1, 2, 3, 4};
        //int[] a3 = new int[4];
        //a3 = a2;
        //a3[1] = 8888;
        //System.out.println("a2:" +Arrays.toString(a2));
        //System.out.println("a3:" +Arrays.toString(a3));
        //
        //a3 = Arrays.copyOf(a2, a2.length);
        //a3[1] = 9999;
        //System.out.println("a2:" +Arrays.toString(a2));
        //System.out.println("a3:" +Arrays.toString(a3));

        //if("-h".equals(args[0])){
        //    System.out.print("Hello,");
        //}else if("-g".equals(args[1])){
        //    System.out.print("GoodBye,");
        //}
        //
        //for(int i=1; i<args.length; i++){
        //    System.out.print(" " + args[i]);
        //}
        //
        //System.out.println("!");

        //int[][] magicSquare = {
        //        {16, 3, 2, 13},
        //        {5, 10, 11, 8},
        //        {9, 6, 120, 8},
        //        {11, 23, 56, 78}
        //};
        //
        //System.out.println(Arrays.toString(magicSquare));
        //System.out.println(Arrays.deepToString(magicSquare));

        NumberFormat format = NumberFormat.getCurrencyInstance();
        System.out.println(format.format(0.10));
        format = NumberFormat.getPercentInstance();
        System.out.println(format.format(0.10));
    }
}
