package com.hhli.springbootstduy.jdk;

import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2018/11/4 18:46
 * @description 退休金计算
 */
public class Retirement {

    public static void main(String[] args) {
        //read inputs
        Scanner in = new Scanner(System.in);

        System.out.print("how much money do you need to retire? ");
        double goal = in.nextDouble();

        System.out.print("How much money will you contribute every year？");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %:");
        double interestRate = in.nextDouble();


        double balance = 0;
        int year = 0;
        while (balance < goal){
            balance += payment;

            double interest = balance * interestRate /100;

            balance += interest;

            year ++;
        }

        System.out.println("You can retire in " + year + " years.");
    }
}
