package com.hhli.springbootstduy.algothrims;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/4/20 21:35
 * @description 螺旋输出demo
 */
public class SpiralMatrix2 {

    public static void main(String[] args) {
        int[][] a ={
                {1,2,3,4},
                {5,6,7,8},
                {9, 10, 11,12}
        };
        System.out.println(spiralOrder(a));

        int[][] b = {
                {1,2,3},
                {4, 5,6},
                {7, 8,9}
        };
        System.out.println(spiralOrder(b));

        int[][] c = {
                {1,2},
        };
        System.out.println(spiralOrder(c));

        int[][] d = {
                {1},
                {2},
        };
        System.out.println(spiralOrder(d));

        int[][] e = {
                {1,2},
                {3, 4},
        };
        System.out.println(spiralOrder(e));

        int[][] f = {};
        System.out.println(spiralOrder(f));
        int[][] g ={
            {}
        };
        System.out.println(spiralOrder(g));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = 0;
        int column = 0;
        int xLen = matrix.length;
        if(xLen==0){
            return new ArrayList<>();
        }
        int yLen = matrix[0].length;
        if(yLen==0){
            return new ArrayList<>();
        }
        List<Integer> integerList = new ArrayList<>(matrix.length * matrix[0].length);
        while (true){
            int beginRow = row;
            int beginColumn = column;
            // right
            for (; column < yLen; column++) {
                //System.out.println("[" + row + "," + column + "]");
                integerList.add(matrix[row][column]);
            }
            if(integerList.size() == matrix.length * matrix[0].length){
                break;
            }
            row++;
            column--;
            //down
            for (; row<xLen; row++) {
                //System.out.println("[" + row + "," + (column) + "]");
                integerList.add(matrix[row][column]);
            }
            if(integerList.size() == matrix.length * matrix[0].length){
                break;
            }
            row--;
            column--;
            //left
            for (; column>=beginColumn; column--) {
                //System.out.println("[" + row + "," + column + "]");
                integerList.add(matrix[row][column]);
            }
            if(integerList.size() == matrix.length * matrix[0].length){
                break;
            }
            row--;
            column++;
            //up
            for (; row>=beginRow+1; row--) {
                //System.out.println("[" + row + "," + column + "]");
                integerList.add(matrix[row][column]);
            }
            if(integerList.size() == matrix.length * matrix[0].length){
                break;
            }
            column++;
            row++;
            xLen --;
            yLen --;
        }

        return integerList;
    }
}
