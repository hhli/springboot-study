package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2019/9/21 19:52
 * @description https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate {

    public static void main(String[] args) {
        //Long temp = 1L;
        //System.out.println(temp.equals(1));

        //System.out.println(findDuplicate(new int[]{3,1,3,4,2}));

        System.out.println(Integer.parseInt("8010203050608"));
    }

    public static int findDuplicateOne(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return  sum -  (nums.length-1) * nums.length / 2;
    }



    public static int findDuplicate(int[] nums) {
        int begin = 1;
        int end = nums.length-1;

        while (begin<end){
            int times = 0;
            int middle = (begin + end + 1)/2;
            for (int num : nums) {
                if(num<middle){
                    times++;
                }
            }

            if(times>=middle){
                end = middle-1;
            }else {
                begin = middle;
            }

            System.out.println("begin=" + begin + ":end=" + end);

        }

        return begin;


        //int len = nums.length;
        //int left = 1;
        //int right = len - 1;
        //while (left < right) {
        //     int mid = left + (right - left + 1) / 2;
        //    //int mid = (left + right + 1) >>> 1;
        //    int counter = 0;
        //    for (int num : nums) {
        //        if (num < mid) {
        //            counter += 1;
        //        }
        //    }
        //    if (counter >= mid) {
        //        // 如果小于 4 的个数等于 4 或者更多
        //        // 那么重复的数一定位于 1、2、3
        //        right = mid - 1;
        //    } else {
        //        left = mid;
        //    }
        //}
        //
        //return left;
    }

}
