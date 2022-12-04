package com.hhli.springbootstduy.algothrims;


import java.util.*;

/**
 * @author 李辉辉
 * @date 2019/6/11 8:56
 * @description
 */
public class ArrayIntersection2 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return new int[]{};
        }

        if(nums2 == null || nums2.length == 0){
            return new int[]{};
        }

        List<Integer> resultList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i : nums1) {
            list1.add(i);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : nums2) {
            list2.add(i);
        }

        for (Integer integer : list1) {
            int index = list2.indexOf(integer);
            if(index != -1){
                resultList.add(integer);
                list2.remove(index);
            }
        }

        int[] a = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            a[i] = resultList.get(i);
        }

        return a;
    }

    public static List<String> generateParenthesis(int n) {
        List<String>[] temp = (ArrayList<String>[])new ArrayList<?>[n];
        temp[0]= new ArrayList<>();
        temp[0].add("()");
        for (int i = 1; i < n; i++) {
            temp[i] = new ArrayList<>();
            for (String s : temp[i-1]) {
                temp[i].add(String.format("()%s", s));
                int right = 0;
                int left = 0;
                for (int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) == '('){
                        right++;
                    }else {
                        left++;
                    }
                    if(left == right){
                        temp[i].add(String.format("(%s)%s", s.substring(0, j+1), s.substring(j+1)));
                    }
                }
            }
        }
        return temp[n-1];
    }
}
