package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/28 9:10
 * @description 不同路径
 */
public class DistinctPath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

    public static  int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return  1;
        }

        return  uniquePaths(m-1, n) + uniquePaths(n-1, m);
    }
}
