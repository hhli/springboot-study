package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2020-04-25 19:37
 * @description
 */
public class SortTest {

    public static void main(String[] args) {
        int[] temp = new int[]{1, 8, 2, 5, 7, 6, 9};
        insertSort(temp);
        System.out.println(Arrays.toString(temp));
    }

    public static void  insertSort(int[] array){
        if(array==null || array.length<=1){
            return ;
        }

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int index = i-1;
            while (index>=0 && array[index]>temp){
                array[index+1] = array[index];
                index--;
            }

            array[index+1] = temp;
        }
    }


}
