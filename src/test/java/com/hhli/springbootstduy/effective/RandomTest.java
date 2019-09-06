package com.hhli.springbootstduy.effective;

import java.util.Random;

/**
 * @author 李辉辉
 * @date 2019/9/5 9:14
 * @description 随机数测试
 */
public class RandomTest {
    static Random random =  new Random();
    
    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i1 = 0; i1 < 1000000; i1++) {
            if(random.nextInt(n) < n/2){
                low++;
            }
        }
        System.out.println(low);
    }

    public static int random(int n){
        return Math.abs(random.nextInt())  * n;
    }
}
