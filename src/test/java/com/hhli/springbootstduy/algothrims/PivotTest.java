package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2020-10-14 08:49
 * @description 寻找数组的中心点
 */
public class PivotTest {
    public int pivotIndex(int[] nums) {
        if(nums==null || nums.length<=2){
            return -1;
        }

        int left=0, leftSum=nums[left];
        int right=nums.length-1, rightSum=nums[right];

        while(right-left>2){
            if(leftSum>rightSum){
                right--;
                rightSum += nums[right];
            }else{
                left++;
                leftSum += nums[left];
            }
        }

        if(leftSum == rightSum){
            return left+1;
        }else{
            return -1;
        }
    }

    public static int pivotIndex1(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }

        if(nums.length==1){
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum == nums[i] + leftSum*2){
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }


    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return -1;
        }

        int left=0, right = nums.length-1;
        System.out.println("left=" + left + ", right=" + right);
        while (left < right){
            int middle = (left + right)/2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] > target){
                right = middle - 1;
            }else {
                left = middle + 1;
            }
            System.out.println("left=" + left + ", right=" + right);
        }

        if(target > nums[left]){
            return  left+1;
        }else {
            return left;
        }
    }


    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 4    ));
    }
}
