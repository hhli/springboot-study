package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2019/3/26 8:46
 * @description 两数之和
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2,4}, 6)));
    }

    public static  int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    a[0] = i;
                    a[1] = j;
                    return  a;
                }
            }
        }
        return  a;
    }
}
