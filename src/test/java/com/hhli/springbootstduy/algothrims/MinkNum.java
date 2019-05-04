package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/5/1 16:36
 * @description  字典序最小k数
 * 请参考https://blog.csdn.net/qq_36946274/article/details/81638367
 */
public class MinkNum {

    public static void main(String[] args) {
        //System.out.println(findKthNumber(1000, 1000));
        //System.out.println(findKthNumber(13, 5));
        //System.out.println(findKthNumber(13, 6));
        //System.out.println(findKthNumber(20, 15));
        //System.out.println(findKthNumber(10, 3));
        //long start = System.currentTimeMillis();
        //System.out.println(findKthNumber(4289384 ,1922239));
        //long end = System.currentTimeMillis();
        //System.out.println("time waste:" + (end -start) + "mills");
        findKthNumber(99, 1);
    }

    public static int findKthNumber(int n, int k) {
        double deep = Math.log10(n+1);
        if(deep == (int)deep){
            //完全十叉树
            int num = k/(n/9);
            int rest = k - num * (n/9);
        }else{
            //不完全十叉树

        }
        return  0;
    }
}
