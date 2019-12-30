package com.hhli.springbootstduy.algothrims;

/**
 *
 * 将30条鱼放入10个桶中，每个桶可以放0-10条，总共有多少种方法
 * @author 李辉辉
 * @date 2019/12/25 21:41
 * @description
 */
public class SplitFish {

    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        //int temp = load(11 );
        //long end = System.currentTimeMillis();
        //System.out.println((end -start) + "mills");
        //System.out.println(temp);
        //System.out.println(splitByNum(6,3));

        System.out.println(splitFish(10, 2, 10));
    }

    /**
     * n=1,1=1
     * n=2,2=1+1
     * n=3,3=1+1+1
     * n=4,5=1+2+1+1
     * n=5,7=1+2+2+1+1
     * n=6,11=1+3+3+2+1+1
     * n=7,=1
     *  如何装 ?  10个桶 每个桶最多放10条
     * @param n  鱼数  n<=30
     * @return
     */
    public static int load(int n){
        int result = 0;
        for (int i = 1; i <= 10; i++) {
            int temp = splitByNum(n, i, n);
            //System.out.println(String.format("i=%d, temp=%d", i, temp));
            result += temp;
        }

        return  result;
    }

    public static int splitByNum(int n, int num, int limit){
        if(n/num > 10){
            return 0;
        }

        if(num == 1){
            return 1;
        }

        int splits = 0;
        int average = (n+num-1)/num;
        int max = n-num+1;
        while(max>=average){
            if(max>limit){
                max--;
                continue;
            }
            splits += splitByNum(n-max, num-1, max);
            max--;
        }
        return splits;
    }

    /**
     * 将 n 条鱼放入 k 个桶，每个桶最多 m 条
     * dp[n,k] = sum(dp[n-1,k-j]), 0<=j<=m
     * 具体解法参考https://juejin.im/post/5cee1a4bf265da1bbf68ff1f
     * @param bucketNum 桶数
     * @param fishNum 鱼的数量
     * @param limit 每个桶能装多少条鱼
     * @return
     */
    public static int splitFish(int bucketNum, int fishNum, int limit){
        int[][] result = new int[bucketNum+1][fishNum+1];

        for (int i = 0; i < fishNum + 1; i++) {
            result[1][i]=1;
        }

        for (int i = 2; i < bucketNum+1; i++) {
            for (int j = 0; j < fishNum + 1; j++) {
                for (int k = 0; k <= limit; k++) {
                    if(j >= k){
                        result[i][j] += result[i-1][j-k];
                    }
                }
            }
        }


        return result[bucketNum][fishNum];
    }

}
