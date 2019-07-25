package com.hhli.springbootstduy.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李辉辉
 * @date 2019/7/25 9:29
 * @description
 */
public class HereMatch {

    public static void main(String[] args) {
        try {
            String urlString;
            if(args.length>0) urlString = args[0];
            else urlString = "http://java.sun.com";

            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(), StandardCharsets.UTF_8);

            //read contents into string builder
            StringBuilder input = new StringBuilder();
            int ch;
            while((ch = in.read()) != -1){
                input.append((char) ch);
            }

            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"[^\\s>]*)\\s*>";
            Pattern pattern  = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()){
                String match = matcher.group();
                System.out.println(match);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
