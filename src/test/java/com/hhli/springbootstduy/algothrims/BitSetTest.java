package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李辉辉
 * @date 2020-04-13 21:50
 * @description
 */
public class BitSetTest {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(retainAll(new int[]{1,2, 3}, new int[]{1,2, 3})));
        //BitSet tempSet = new BitSet();

        //for (int i = 0; i < Integer.MAX_VALUE; i++) {
        //    tempSet.set(i);
        //    System.out.println(i);
        //}
        //
        //tempSet.set(1);
        //tempSet.set(56);
        //System.out.println(1>>1 + 1>>56);
        //System.out.println(tempSet.cardinality());

        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    public static int[] retainAll(int[] array1, int[] array2){
        BitSet tempSet = new BitSet();
        for (int i : array1) {
            tempSet.set(i);
        }

        int setLen = tempSet.length()-1;
        for (int j : array2) {
            if(tempSet.get(j)){
                tempSet.clear(j);
                setLen--;
            }
        }

        int index  = 0;
        int[] result = new int[array1.length - setLen];
        if(result.length>0){
            for (int i : array1) {
                if(!tempSet.get(i)){
                    result[index++] = i;
                }
            }
        }

        return result;
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0){
            return new int[0];
        }

        if(nums2==null || nums2.length==0){
            return new int[0];
        }

        if(nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> countMap = new HashMap<>(nums1.length);
        for (int i : nums1) {
            int count = 0;
            if(countMap.containsKey(i)){
                count = countMap.get(i);
            }

            count++;
            countMap.put(i, count);
        }

        int k = 0;
        for (int j : nums2) {
            int temp = countMap.getOrDefault(j, 0);
            if(temp>0){
                nums1[k] = j;
                countMap.put(j, temp-1);
                k++;
            }
        }


        return Arrays.copyOfRange(nums1, 0, k);
    }
}
