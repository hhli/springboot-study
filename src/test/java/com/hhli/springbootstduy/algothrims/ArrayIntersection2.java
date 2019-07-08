package com.hhli.springbootstduy.algothrims;

import java.util.*;

/**
 * @author 李辉辉
 * @date 2019/6/11 8:56
 * @description
 */
public class ArrayIntersection2 {

    public static void main(String[] args) {

    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return new int[]{};
        }

        if(nums2 == null || nums2.length == 0){
            return new int[]{};
        }

        List<Integer> resultList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : nums2) {
            list2.add(i);
        }

        for (Integer integer : list1) {
            int index = list2.indexOf(integer);
            if(index != -1){
                resultList.add(integer);
                list2.remove(index);
            }
        }

        int[] a = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            a[i] = resultList.get(i);
        }

        return a;
    }
}
