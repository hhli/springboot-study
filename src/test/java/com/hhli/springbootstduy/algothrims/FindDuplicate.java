package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/9/21 19:52
 * @description
 */
public class FindDuplicate {

    public static void main(String[] args) {

    }

    public static int findDuplicate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return  sum -  (nums.length-1) * nums.length / 2;
    }
}
