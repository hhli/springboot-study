package com.hhli.springbootstduy.algothrims;

import java.util.*;

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


    public static int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> result = new ArrayList<>(intervals.length);
        result.add(intervals[0]);
        for (int[] interval : intervals) {
            if(interval[0]>result.get(result.size()-1)[1]){
                result.add(interval);
            }else{
                if(interval[1]>result.get(result.size()-1)[1]){
                    result.get(result.size()-1)[1] = interval[1];
                }
            }
        }

        return result.toArray(new int[][]{});
    }


    public static void rotate(int[][] matrix) {
        if(matrix !=null && matrix.length>1){
            int n = matrix.length;

            //矩阵上下交换
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n; j++) {
                     int temp = matrix[i][j];
                     matrix[i][j] = matrix[n-i-1][j];
                     matrix[n-i-1][j] = temp;
                }
            }

            //对角线交换
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i<j){
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }
            }

        }

    }

    public static void setZeroes(int[][] matrix) {
        if(matrix!=null && matrix.length>0) {
            Set<Integer> rowSet = new HashSet<>(matrix.length);
            Set<Integer> colSet = new HashSet<>(matrix[0].length);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 0){
                        rowSet.add(i);
                        colSet.add(j);
                    }
                }
            }
            if(!rowSet.isEmpty()){
                for (Integer i : rowSet) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }

                for (int i = 0; i < matrix.length; i++) {
                    for (Integer j : colSet) {
                        matrix[i][j] = 0;
                    }
                }

            }
        }

    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }

        int[] temp = new int[matrix.length * matrix[0].length];

        int row = 0, col = 0;
        int index = 0;
        temp[index] = matrix[row][col];

        for (int i = 1; i < matrix.length + matrix[0].length-1; i++) {
            if(col<matrix[0].length-1){
                col++;
            }else{
                row++;
            }

            List<Integer> tempList = new ArrayList<>();
            tempList.add(matrix[row][col]);

            int tempRow=row, tempCol=col;
            while(tempCol>0 && tempRow<matrix.length-1){
                tempList.add(matrix[++tempRow][--tempCol]);
            }

            System.out.println("tempList" + tempList);
            if(i%2==0){
                //逆向添加
                for (int j = tempList.size() - 1; j >= 0; j--) {
                    temp[++index] = tempList.get(j);
                }
            }else{
                //正向添加
                for (int j = 0; j < tempList.size(); j++) {
                    temp[++index] = tempList.get(j);
                }
            }

        }

        return temp;
    }

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(1, 5, 2, 7, 9);
        //list.sort(Comparator.comparingInt(Integer::intValue));
        //System.out.println(list);
        //int[][] temp = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] temp = {{1,8},{2,3}};
        //merge(temp);
        int[] temp = findDiagonalOrder(new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}});

        System.out.println(Arrays.toString(temp));
    }
}
