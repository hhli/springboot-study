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
        if(m == 0 || n == 0){
            return  0;
        }

        int[][] a = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == 1 || j == 1){
                    a[i][j] = 1;
                }else{
                    a[i][j] = a[i-1][j] + a[i][j-1];
                }
            }
        }

        return  a[m][n];
    }
}
