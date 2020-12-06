package com.hhli.springbootstduy.algothrims;

import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2020-05-25 12:20
 * @description
 */
public class TestDefalut {

    public void reverseString(char[] s){
        if(s == null ||  s.length<=1){
            return;
        }

        int head = 0, tail = s.length-1;
        char temp;
        while (head<tail){
            temp = s[head];
            s[head] = s[tail];
            s[tail]=temp;
            head++;
            tail--;
        }
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            sum += nums[i];
        }

        return sum;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i=0, j = numbers.length-1;
        while (i<j){
            int temp = numbers[i] + numbers[j];
            if(temp == target){
                result[0] = i;
                result[1] = j;
                break;
            }else if(temp < target){
                i++;
            }else{
                j--;
            }
        }

        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        //CountDownLatch latch = new CountDownLatch(2);
        //
        //new Thread(()->{
        //    latch.countDown();
        //    Thread.currentThread().interrupt();
        //}).start();
        //
        //Thread.currentThread().interrupt();
        //
        //latch.await(1, TimeUnit.SECONDS);

        System.out.println(-2/2);

    }

}
