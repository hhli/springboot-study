package com.hhli.springbootstduy.algothrims;

import org.springframework.context.annotation.Bean;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/7/21 11:22
 * @description 最长公共字串
 */
public class LongestStringSolution {
    public static String longestCommonPrefix(String[] strs) {
        if(Objects.isNull(strs) ||strs.length ==0){
            return "";
        }

        int end = 0;
        boolean result = false;
        while (!result){
            char ch;
            if(end < strs[0].length()){
                ch = strs[0].charAt(end);
            }else{
                break;
            }

            int i;
            for (i = 1; i < strs.length; i++) {
                if(end >= strs[i].length()){
                    result = true;
                    break;
                }
                if(ch != strs[i].charAt(end)){
                    result = true;
                    break;
                }
            }

            if(i == strs.length){
                end++;
            }
        }

        if(end > 0){
            return  strs[0].substring(0, end);
        }else{
            return "";
        }

    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
