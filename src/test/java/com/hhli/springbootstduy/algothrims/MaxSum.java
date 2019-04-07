package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/6 21:59
 * @description 最大和
 */
public class MaxSum {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,8};
        System.out.println(maxSubArray(nums));
    }
    public static  int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(sum[i-1] + nums[i], nums[i]);
        }

        int max = sum[0];
        for (int i : sum) {
            if(i>max) max = i;
        }

        return  max;
    }
}
