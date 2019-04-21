package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/21 10:38
 * @description n*n螺旋矩阵生成 m*n的矩阵呢
 */
public class SpiralMatrix3 {

    public static void main(String[] args) {
        int[][] a = generateMatrix(0);
        a = generateMatrix(2);
        a = generateMatrix(3);
        a = generateMatrix(4);
    }

    public static  int[][] generateMatrix(int n) {
        if(n == 0){
            int[][] a = {};
            return a;
        }else{
            int[][] a = new int[n][n];

            int  row = 0, column = 0;
            int rowLen = n, columnLen = n;
            int i = 0;
            while (true){
                int beginRow = row;
                int beginColumn  = column;

                //right
                for(; column<columnLen; column++){
                    i++;
                    a[row][column] = i;
                }
                if(i == n *n){
                    break;
                }
                column--;
                //从下一行开始遍历
                row++;


                //down
                for(;row<rowLen; row++){
                    i++;
                    a[row][column] = i;
                }
                if(i == n *n){
                    break;
                }
                row--;
                //从下一列开始遍历
                column--;


                //left
                for(;column>=beginColumn; column--){
                    i++;
                    a[row][column] = i;
                }
                if(i == n *n){
                    break;
                }
                column++;
                row--;


                //up
                for(; row>=beginRow+1; row--){
                    i++;
                    a[row][column] = i;
                }
                if(i == n *n){
                    break;
                }

                row++;
                column++;
                rowLen--;
                columnLen--;
            }

            return  a;
        }
    }
}
