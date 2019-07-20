package com.hhli.springbootstduy.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author 李辉辉
 * @date 2019/7/20 18:16
 * @description 并行流测试
 */
public class ParallelStreams {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\github\\springboot-study\\src\\test\\resources\\example.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s->{ if(s.length()<10) shortWords[s.length()]++;});
        System.out.println(Arrays.toString(shortWords));

        Map<Integer, Long> shortWordCounts = wordList.parallelStream().filter(s->s.length()<10).collect(groupingBy(String::length, counting()));
        System.out.println(shortWordCounts);

        Map<Integer, List<String>> result = wordList.parallelStream().collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        result = wordList.parallelStream().collect(groupingByConcurrent(String::length));
        System.out.println(result.get(14));

        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(groupingByConcurrent(String::length, counting()));
        System.out.println(wordCounts);
    }
}
