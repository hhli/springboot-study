package com.hhli.springbootstduy.algothrims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2020-04-11 15:57
 * @description
 */
public class SubTest {

    public static void main(String[] args) {
        System.out.println("2019".compareTo("319"));
    }

    public static String sub(){
        List<String> strList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            strList.add(in.nextLine());
            if(strList.size() == 2){
                break;
            }
        }

        String a = strList.get(0);
        String b = strList.get(1);

        int len  = a.length()>b.length() ? a.length() : b.length();
        StringBuilder result = new StringBuilder();

        //借位
        int temp = 0;
        for(int i=0; i<len; i++){
            int t =  a.charAt(a.length()-1-i) - b.charAt(a.length()-1-i) + temp;
            if(t<0 && i!=len-1){
                t = t + 10;
                temp = -1;
                result.append(t);
            }else if(t<0 && i == len-1){
                if(len ==  a.length()){

                } else {

                }
            }
        }


        return  "";
    }
}


