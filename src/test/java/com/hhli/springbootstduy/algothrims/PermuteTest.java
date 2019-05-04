package com.hhli.springbootstduy.algothrims;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/5/4 17:12
 * @description 全排列
 */
public class PermuteTest {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(Objects.isNull(nums) || nums.length == 0){
            return  result;
        }

        if(nums.length==1){
            List<Integer> tempList  = new ArrayList<>();
            tempList.add(nums[0]);
            result.add(tempList);

            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] numTemp = new int[nums.length-1];
            for (int j = 0; j < nums.length - 1; j++) {
                if(j<i){
                    numTemp[j] = nums[j];
                }else{
                    numTemp[j] = nums[j+1];
                }
            }

            List<List<Integer>> temp = permute(numTemp);
            for (List<Integer> integerList : temp) {
                integerList.add(nums[i]);
                result.add(integerList);
            }
        }

        return  result;
    }
}
