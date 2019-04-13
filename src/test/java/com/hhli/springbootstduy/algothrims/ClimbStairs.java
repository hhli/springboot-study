package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/12 0:03
 * @description
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(5));
    }

    public int climbStairs(int n) {

        int[] a = new int[n +1];

        for (int i = 0; i < n+1; i++) {
            if(i <=2){
                a[i] = i;
            }else{
                a[i] =  a[i-1] +  a[i-2];
            }
        }

        return  a[n];
    }
}
