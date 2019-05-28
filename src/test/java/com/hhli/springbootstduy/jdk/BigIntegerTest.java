package com.hhli.springbootstduy.jdk;

import java.util.Date;

/**
 * @author 李辉辉
 * @date 2018/11/4 20:55
 * @description
 */
public class BigIntegerTest {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //
        //System.out.print("How many numbers do you need to draw? ");
        //int k = in.nextInt();
        //
        //System.out.print("what is the highest number you can draw?");
        //int n = in.nextInt();
        //
        ///*
        //* compute binomial coefficient n*(n-1)*(n-2)....(n-k+1)/(1*2*3*....K)
        // */
        //BigInteger lotteryOdds = BigInteger.valueOf(1);
        //
        //for(int i=1; i<=k; i++){
        //    lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        //}
        //
        //System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");

        Employee employee = new Employee(){
            {
                setHireDay(new Date());
                setId();
            }

        };

        System.out.println(employee);
    }
}
