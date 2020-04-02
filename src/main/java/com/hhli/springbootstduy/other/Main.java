package com.hhli.springbootstduy.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2020-03-03 15:51
 * @description
 */
public class  Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the num");
        int len = sc.nextInt();
        if(len<=0){
            throw new IllegalArgumentException("num必须大于0");
        }

        int[] temp = new int[len];
        String  str = sc.next();
        if(str != null && str.length()>0){
            String[] strs = str.split(" ");
            for(int i = 0; i<strs.length; i++){
                temp[i] = Integer.parseInt(strs[i]);
            }
        }

        System.out.println(isRepeat(temp));
    }

    public  static String isRepeat(int[] arr){
        if(arr == null || arr.length == 0){
            return "NO";
        }

        Map<Integer, String> tempMap = new HashMap<>(32);
        for(int i=0; i<arr.length; i++){
            if(tempMap.containsKey(arr[i])){
                return "YES";
            }else{
                tempMap.put(arr[i], "111");
            }
        }

        return "NO";
    }
}