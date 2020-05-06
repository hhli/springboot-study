package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李辉辉
 * @date 2020-04-28 08:58
 * @description 两数之和
 */
public class TwoSum2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }

    public static  int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[0];
        }

        int[] result = new int[0];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    result = new int[2];
                    result[0] = i;
                    result[1] =j;
                    break;
                }
            }
            if(result.length>0){
                break;
            }
        }


        return result;
    }


    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
