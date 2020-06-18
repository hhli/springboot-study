package com.hhli.springbootstduy.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author 李辉辉
 * @date 2019/8/3 21:17
 * @description try-with-resources测试
 */
public class AutoCloseableTest {

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader("test.sql"))){
            System.out.println(reader.lines().count());
        }

        Reader reader = null;
        if(reader instanceof  Reader){
            System.out.println("ttt");
        }

    }

}
