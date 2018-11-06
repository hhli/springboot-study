package com.hhli.springbootstduy.jdk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2018/11/6 8:20
 * @description
 */
public class LotteryDrawing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("how many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.print("what's the highest number you can draw");
        int n = in.nextInt();

        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = i +1;
        }

        // draw k numbers and put them into  a second array
        int[] result = new int[k];
        for(int i=0; i<result.length; i++){
            int r = (int)(Math.random() * n);

            result[i] =  numbers[r];

            numbers[r] = numbers[n -1];
            n--;

        }

        System.out.println(Arrays.toString(result));

        Arrays.sort(result);
        System.out.println("Bet the following combination, It'will make you rich!!");

        System.out.println(Arrays.toString(result));
    }
}
