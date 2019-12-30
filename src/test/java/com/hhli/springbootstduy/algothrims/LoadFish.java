package com.hhli.springbootstduy.algothrims;

/**
 *
 * @author 李辉辉
 * @date 2019/12/25 21:41
 * @description 将 30 条鱼放入 10 个桶中，每个桶可以放 0-10 条，总共有多少种方法
 */
public class LoadFish {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int temp = load(11 );
        long end = System.currentTimeMillis();
        System.out.println((end -start) + "mills");
        System.out.println(temp);
        //System.out.println(splitByNum(6,3));
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
}
