package com.hhli.springbootstduy.io;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/7/20 20:53
 * @description 输入输出测试
 */
public class IoTest1 {

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream(new File("D:\\github\\springboot-study\\src\\test\\resources\\example.txt"));
        int byteAvailable = in.available();
        System.out.println("byte length=" + byteAvailable);
        in.close();

        String content = new String(Files.readAllBytes(Paths.get("")), StandardCharsets.UTF_8);
        List<String> lines = Files.readAllLines(Paths.get(""));
        Stream<String> fileStream =  Files.lines(Paths.get(""));
        Scanner scanner = new Scanner(new File(""));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
        }

        InputStream inputStream = new FileInputStream("");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
            String line;
            while (StringUtils.isNotBlank(line=reader.readLine())){
                System.out.println(line);
            }

        }


    }
}
