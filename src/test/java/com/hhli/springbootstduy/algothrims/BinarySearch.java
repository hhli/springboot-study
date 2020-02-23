package com.hhli.springbootstduy.algothrims;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/4/6 17:19
 * @description 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            indexWithRecursion(array, 0, array.length-1, 3);
            indexWithRecursion(array, 0, array.length-1, 100);
            indexWithRecursion(array, 0, array.length-1, 501);
        }
        System.out.println("cost time is:" + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            indexWithoutRecursion(array, 3);
            indexWithoutRecursion(array,  100);
           indexWithoutRecursion(array, 501);
        }
        System.out.println("cost time is:" + (System.currentTimeMillis() - start) + "ms");

        System.out.println(0 & ((1 << 29) - 1));
    }

    /**
     *  用递归查询数组
     * @param array
     * @param begin
     * @param end
     * @param key
     * @return
     */
    public static int indexWithRecursion(int [] array, int begin, int end, int key){
        if(array.length == 0) return  -1;
        if(begin > end) return  -1;

        int middle =  (begin + end) / 2 ;
        if(array[middle] == key){
            return  middle;
        }else if(array[middle] > key){
            return  indexWithRecursion(array, begin, middle-1, key);
        }else{
            return  indexWithRecursion(array, middle+1, end, key);
        }
    }

    public static  int indexWithoutRecursion(int [] array, int key){
        if(Objects.isNull(array) || array.length==0){
           return -1;
        }

        int begin = 0;
        int end = array.length -1;
        int index = -1;

        while (begin <= end){
            int middle =  (begin + end) / 2 ;
            if (array[middle] == key){
                index =   middle;
                break;
            }else if(array[middle] > key){
                end = middle -1;
            }else{
                begin = middle +1;
            }
        }

        return  index;
    }

}
