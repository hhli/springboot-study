package com.hhli.springbootstduy.io;

import org.apache.commons.lang.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李辉辉
 * @date 2019/7/24 22:44
 * @description 正则表达式测试
 */
public class RegularTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern:");
        String patternString = in.nextLine();

        Pattern pattern = Pattern.compile(patternString);
        while (true){
            System.out.println("Enter string to match");
            String input = in.nextLine();
            if(StringUtils.isBlank(input)) return;

            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){
                System.out.println("Match");
                int g = matcher.groupCount();
                if(g > 0){
                    for (int i = 0; i < input.length(); i++) {
                        // print any empty groups
                        for (int j = 1; j <= g; j++) {
                            if(i == matcher.start(j) &&  i == matcher.end(j)){
                                System.out.print("()");
                            }
                        }

                        // print ( for non-empty group starting here
                        for (int j = 1; j <= g; j++) {
                            if(i == matcher.start(j) &&  i != matcher.end(j)){
                                System.out.print("(");
                            }
                        }

                        System.out.print(input.charAt(i));
                        for (int j = 1; j <= g; j++) {
                            if(i+1 != matcher.start(j) &&  i+1 == matcher.end(j)){
                                System.out.print(")");
                            }
                        }

                    }
                    System.out.println();
                }
            }else{
                System.out.println("No match~~");
            }
        }
    }
}
