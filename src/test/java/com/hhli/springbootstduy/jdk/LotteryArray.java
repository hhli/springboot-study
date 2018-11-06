package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2018/11/6 9:11
 * @description 不规则数组测试
 */
public class LotteryArray {

    public static void main(String[] args) {
        final int max = 10;

        int[][] odds = new int[max +1][];
        for(int i= 0; i<=max; i++){
            odds[i] = new int[i+1];
        }

        for(int n=0; n<odds.length ; n++){
            for(int k=0; k<odds[n].length; k++){
                int lotteryOdds = 1;
                for(int i=1; i<=k; i++){
                    lotteryOdds = lotteryOdds * (n - i + 1)/i;
                }
                odds[n][k] = lotteryOdds;
            }
        }

        for(int[] row : odds){
            for(int odd : row){
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }

}
