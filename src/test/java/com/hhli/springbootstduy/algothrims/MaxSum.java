package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/4/6 21:59
 * @description 最大和
 */
public class MaxSum {

    public static void main(String[] args) {
        int[] nums = {-2,-1,3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(nums));
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

    public static  int maxSubArray2(int[] nums) {
        int ans = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i <nums.length; i++){
            if(ans < 0) ans = 0;
            ans += nums[i];
            max = Math.max(max, ans);
        }
        return max;
    }

    public static int maxSubArray3(int[] nums){
        return  divide(nums, 0, nums.length-1);
    }

    public static int divide(int[] nums, int begin, int end){
        if(begin == end)  return nums[begin];
        if(begin == end-1) return Math.max(nums[begin], Math.max(nums[end], nums[begin]+nums[end]));

        int mid = (begin+ end)>>1;
        int lret = divide(nums, begin, mid-1);
        int rret = divide(nums, mid+1, end);

        int mret = nums[mid];
        int sum = mret;
        for(int i = mid-1; i >= begin ; i --) {
            sum += nums[i];
            mret = Math.max(mret, sum);
        }
        sum = mret;    //保存已经计算过的左边的最大子序和
        for(int i = mid+1; i <= end ; i ++) {
            sum += nums[i];
            mret = Math.max(mret, sum);
        }

        return Math.max(lret, Math.max(rret, mret));
    }
}
