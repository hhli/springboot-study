package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2019/4/21 12:43
 * @description 下一个序列
 */
public class NextPermutation {

    public static void main(String[] args) {
        nextPermutation(new int[]{1,1,5});
        System.out.println();
        nextPermutation(new int[]{5,1,1});
        System.out.println();
        nextPermutation(new int[]{1,2, 3});
        System.out.println();
        nextPermutation(new int[]{3,2, 1});
    }

    public static  void nextPermutation(int[] nums) {
        //从后往前数，比第一个比最后一个元素大的下标
        int index = -1;
        int temp;
        for(int j=nums.length-1; j>=0; j--){
            if(nums[nums.length-1] < nums[j]){
                temp = nums[nums.length-1];
                nums[j] = temp;
                nums[nums.length-1] = nums[j];
                index = j;
                break;
            }
        }

        if(index == -1){
            int middle = nums.length/2;
            for(int i =0; i<middle; i++){
                 temp = nums[nums.length -i -1];
                 nums[nums.length-i-1] = nums[i];
                 nums[i] = temp;
            }
        }else{

        }

        System.out.println(Arrays.toString(nums));
    }
}
