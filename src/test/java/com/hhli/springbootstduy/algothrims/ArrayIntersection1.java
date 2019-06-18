package com.hhli.springbootstduy.algothrims;

import java.util.*;

/**
 * @author 李辉辉
 * @date 2019/6/11 8:33
 * @description 数组交集
 */
public class ArrayIntersection1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return new int[]{};
        }

        if(nums2 == null || nums2.length == 0){
            return new int[]{};
        }

        BitSet numSet = new BitSet();
        for (int i : nums1) {
            numSet.set(i);
        }

        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if(numSet.get(i)){
                result.add(i);
            }
        }

        int[] a = new int[result.size()];
        int i = 0;
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()){
            int temp = iterator.next();
            a[i] = temp;
            i++;
        }

        return a;
    }
}
