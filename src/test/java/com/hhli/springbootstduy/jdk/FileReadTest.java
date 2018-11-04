package com.hhli.springbootstduy.jdk;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2018/11/4 16:56
 * @description
 */
public class FileReadTest {

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(Paths.get("../1.txt"))) {
            while (in.hasNext()){
                System.out.println(in.next());
            }
        }

    }
}
