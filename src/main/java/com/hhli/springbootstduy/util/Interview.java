package com.hhli.springbootstduy.util;

import java.util.*;

public class Interview {

    public static void main(String[] args) {
//        System.out.println(numGame(100));
//
//        String[] temp = new String[]{"a", "app", "ap", "b", "ba", "bba"};
//        Arrays.sort(temp, (a, b) ->  {
//            if (a.length() != b.length()) {
//                return a.length() - b.length();
//            } else {
//                return b.compareTo(a);
//            }});
//
//        System.out.println(Arrays.toString(temp));

        System.out.println(search(new int[]{1,2,3,4,4,5,6,7,7,8,8,8,9,10,10}, 10));
    }


    public static int numGame(int n){
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }

        int i = 0;
        int last = 0;
        int cur = numList.size();
        List<Integer> remList = new ArrayList<>();
        while(true){
            i++;
            if(String.valueOf(i).contains("7") || i%7 == 0){
                remList.add(numList.get((i - last - 1) % (cur -last)));
            }

            if(i <= cur){
                continue;
            }

            System.out.println(remList);
            numList.removeAll(remList);

            if(numList.size() == 1){
                break;
            }
            remList.clear();
            last = cur;
            cur += numList.size();
        }

        return numList.get(0);
    }


    public static  int search(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }

        int begin = 0;
        int end = arr.length-1;
        int res = Integer.MAX_VALUE;
        while(begin <= end){
            int mid  = (begin + end)/2;
            if(arr[mid] == target && mid < res){
                res = mid;
                end = mid - 1;
            }else if(arr[mid] > target){
                end = mid -1;
            }else if(arr[mid] < target){
                begin = mid + 1;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
