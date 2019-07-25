package com.hhli.springbootstduy.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
