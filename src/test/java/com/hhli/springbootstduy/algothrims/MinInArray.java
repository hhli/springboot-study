package com.hhli.springbootstduy.algothrims;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/5/4 18:47
 * @description 先升后降查询最小值
 */
public class MinInArray {

    public static void main(String[] args) {
        int[] temp = new int[]{8, 2, 1, 6,7};


    }

    public static int solve(int[] nums){
        if(Objects.isNull(nums) || nums.length<3){
            throw  new RuntimeException("nums不能为空并且参数长度不小于3");
        }

        if(nums.length == 3){
            return nums[1];
        }

        int begin = 0;
        int end = nums.length-1;
        int index = 0;
        while(begin <= end){
            int middle = (begin + end)/2;
            if(nums[middle-1]>nums[middle] && nums[middle]>nums[middle+1]){
                begin = middle;
            }else if(nums[middle-1]<nums[middle] && nums[middle]<nums[middle+1] ){
                end = middle;
            }else{
                index = middle;
                break;
            }
        }

        return nums[index];
    }
}
