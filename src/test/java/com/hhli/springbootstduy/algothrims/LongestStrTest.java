package com.hhli.springbootstduy.algothrims;

/**
 * @author 李辉辉
 * @date 2020-11-13 17:08
 * @description 最长公共子传
 */
public class LongestStrTest {
    public  String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = getPalindromeIndex(s.charAt(i), s, i);
            if(index != -1 && (index-i)>(end - start)){
                start = i;
                end = index;
            }
        }

        return s.substring(start, end+1);
    }

    private int getPalindromeIndex(char ch, String s, int i){
        System.out.println("ch=" + ch + ",i=" + i);
        int index = s.lastIndexOf(ch);
        while(index!=-1 && index!=i){
            boolean result = false;
            String tempStr = s.substring(i, index+1);
            System.out.println("tempStr=" + tempStr);
            for (int j = 0; j < tempStr.length(); j++) {
                if(tempStr.charAt(j) != tempStr.charAt(tempStr.length()-j-1)){
                    result=true;
                    break;
                }
            }

            if(!result){
                break;
            }

            index = s.substring(i, index).lastIndexOf(ch) + i;
        }

        return index;
    }


    public static void main(String[] args) {
        LongestStrTest test = new LongestStrTest();
        System.out.println(test.longestPalindrome("babbd"));
    }
}
