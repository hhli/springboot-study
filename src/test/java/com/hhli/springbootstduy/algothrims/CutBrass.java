package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2019/4/6 19:03
 * @description 切铜条
 */
public class CutBrass {

    public static void main(String[] args) {
        int[] p0 ={1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        //System.out.println(cut(p, 15));
        //
        ////
        //int n = 15;
        //int[] r = new int[n+1];
        //for (int i = 0; i < n+1; i++) {
        //    r[i] = -1;
        //}
        //
        //System.out.println(cut(p, n, r));


        int n = 15;
        int[] p = new int[n];
        System.arraycopy(p0, 0, p, 0, p0.length);

        System.out.println(Arrays.toString(p));

        System.out.println(cutByDP(p));
    }

    public static int cut(int []p,int n) {
        if(n==0)
            return 0;

        int q=Integer.MIN_VALUE;
        for(int i=1;i<=p.length;i++) {
            if(n<i){
                break;
            }
            q=Math.max(q, p[i-1]+cut(p, n-i));
        }

        return q;
    }


    public static int cut(int[] p,int n, int[] r) {
        int q=-1;
        if(r[n]>=0)
            return r[n];
        if(n==0)
            q=0;
        else {
            for(int i=1;i<=p.length;i++){
                if(n<i){
                    break;
                }
                q=Math.max(q, cut(p, n-i)+p[i-1]);
            }

        }
        r[n]=q;

        return q;
    }

    public static int cutByDP(int[] p){
        int[] r = new int[p.length+1];
        for (int i = 1; i <= p.length; i++) {
            int q = -1;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j-1] + r[i-j]);
            }
            r[i] = q;
        }

        return  r[p.length];
    }
}
