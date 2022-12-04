package com.hhli.springbootstduy.algothrims;

import java.util.*;

/**
 * @author 李辉辉
 * @date 9/9/22 11:12 AM
 * @description
 */
public class NuccTest {

    /**
     * 测试main方法，忽略
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(firstCharacter("qqqqq"));
        //System.out.println(firstCharacter("qbqqa"));
        //System.out.println(firstCharacter("qbqqa"));

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);
    }

    /**
     * 返回目标字符串中第一个不重复的字符
     * @param s 目标字符串
     * @return 0表示没有找到，其他情况为找到的第一个不重复的字符。
     */
    public static char firstCharacter(String s){
        if(s == null || s.length() ==0){
            return 0;
        }

        Map<Character, Integer> char2Times = new LinkedHashMap<>();

        char[] tempArray = s.toCharArray();
        for (char c : tempArray) {
            int times = char2Times.getOrDefault(c, 0);
            char2Times.put(c, times + 1);
        }

        char c = 0;

        for (Map.Entry<Character, Integer> entry : char2Times.entrySet()) {
            if(entry.getValue() == 1){
                c = entry.getKey();
                break;
            }
        }

        return c;

    }

}
