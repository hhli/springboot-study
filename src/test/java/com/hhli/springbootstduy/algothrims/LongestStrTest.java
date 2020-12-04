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



    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int index = 0; index < n; ++index) {
            for (int i = 0; i + index < n; ++i) {
                int j = i + index;
                if (index == 0) {
                    dp[i][j] = true;
                } else if (index == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && index + 1 > ans.length()) {
                    ans = s.substring(i, i + index + 1);
                }
            }
        }
        return ans;
    }

    public String reverseWords(String s){
        if(s == null){
            return null;
        }

        s = s.trim();


        StringBuilder resultBuilder = new StringBuilder();

        String[] tempArray = s.split(" ");
        for (int i = tempArray.length - 1; i >= 0; i--) {
            if(tempArray[i].equals("")){
                continue;
            }
            resultBuilder.append(tempArray[i]).append(" ");
        }


        return  resultBuilder.deleteCharAt(resultBuilder.length()-1).toString();
    }


    public int strStr(String haystack, String needle) {
        if(needle.length()> haystack.length()){
            return -1;
        }

        if("".equals(needle)){
            return 0;
        }


        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            int temp = i;
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(temp) != needle.charAt(j)){
                    break;
                }
                temp++;
            }

            if(temp-i == needle.length()){
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        //LongestStrTest test = new LongestStrTest();
        //System.out.println(test.longestPalindrome2("aacdkcbc"));


        //String error = String.format("房屋id=%d在城市id=%d不存在", 11, 11);
        //
        //System.out.println(error);

        //System.out.println(test.reverseWords("a good   example"));

        System.out.println(new StringBuilder("a good   example").reverse().toString());
    }
}
