package com.hhli.springbootstduy.algothrims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2020-05-25 12:20
 * @description
 */
public class TestDefault {

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

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return  0;
        }

        int slow=0;
        for (int num : nums) {
            if(val != num){
                nums[slow]  = num;
                slow++;
            }
        }

        return slow;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int temp = 0;
        for (int num : nums) {
            if(num == 1){
                slow++;
            } else {
                if(slow>temp){
                    temp = slow;
                }
                slow = 0;
            }
        }

        if(slow > temp){
            temp = slow;
        }

        return temp;
    }


    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0, temp = Integer.MAX_VALUE, slow=0, fast=0;
        while (fast<nums.length){
            sum += nums[fast];
            if(sum>=s) {
                if (temp > fast - slow + 1) {
                    temp = fast - slow + 1;
                }
                slow++;
                fast = slow;
                System.out.println("slow=" + slow);
                sum = 0;
            }else{
                fast++;
            }
        }

        return temp == Integer.MAX_VALUE ? 0 : temp;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i+1);
            for (int j = 0; j < i+1; j++) {
                if(j==0 || j==i){
                    temp.add(1);
                } else {
                    List<Integer> lasList = result.get(i-1);
                    temp.add(lasList.get(j)+ lasList.get(j-1));
                }
            }

            result.add(temp);
        }

        return result;
    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new ArrayList<>(rowIndex+1);
        for (int i = 0; i < rowIndex+1; i++) {
            resultList.add(0);
        }
        resultList.set(0,1);
        for (int i = 1; i < rowIndex+1; i++) {
            for (int j = i; j > 0; j--) {

                resultList.set(j, resultList.get(j) + resultList.get(j-1));
            }
        }

        return resultList;
    }

    public String reverseWords(String s) {
        if(s==null || s.length()<=1){
            return s;
        }

        char[] tempArray = s.toCharArray();
        char temp;
        int slow=0, fast=0;
        while (fast < tempArray.length){
            if(tempArray[fast] == 32){
                for (int j = 0; j < (fast-slow+1)/2; j++) {
                    temp = tempArray[slow+j];
                    tempArray[slow+j] = tempArray[fast-1-j];
                    tempArray[fast-1-j] = temp;
                }
                fast++;
                slow = fast;
            }else{
                fast++;
            }
        }

        if(slow!=fast){
            for (int j = 0; j < (fast-slow+1)/2; j++) {
                temp = tempArray[slow+j];
                tempArray[slow+j] = tempArray[fast-1-j];
                tempArray[fast-1-j] = temp;
            }
        }
        
        return new String(tempArray);
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

        //System.out.println(-2>>1);
        //System.out.println(default1.generate(5));
        TestDefault default1 = new TestDefault();
        System.out.println(default1.reverseWords("Let's take LeetCode contest"));
    }

}
