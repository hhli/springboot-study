package com.hhli.springbootstduy.beancopy;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2020-02-15 10:26
 * @description 快速排序测试
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] array = { 23, 46, 0, 8, 11, 18 };
        quickSort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
    }


    private static void quickSort(int[] array, int low, int high){
        if(Objects.isNull(array) || array.length<=1){
            return;
        }

        if(high>low){
            int index = getIndex(array, low, high);
            quickSort(array, 0, index-1);
            quickSort(array, index+1, high);
        }
    }

    private  static int getIndex(int[] array, int low, int high){
        //基准数据
        int temp = array[low];

        while (low < high){

            while(low<high && array[high]>=temp){
                high--;
            }
            //当队首元素大于temp，交换位置
            array[low] = array[high];
            System.out.println(Arrays.toString(array));


            while (low<high && array[low]<=temp){
                low++;
            }
            //当队首元素大于temp，交换位置
            array[high] = array[low];
            System.out.println(Arrays.toString(array));
        }


        array[low] = temp;
        System.out.println(Arrays.toString(array));
        return low;
    }


}
