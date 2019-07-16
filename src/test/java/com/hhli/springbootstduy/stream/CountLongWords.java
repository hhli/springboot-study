package com.hhli.springbootstduy.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/7/16 8:53
 * @description 用stream的形式统计单词
 */
public class CountLongWords {

    public static void main(String[] args) throws IOException {
        //String contents = new String(Files.readAllBytes(Paths.get("D:\\github\\springboot-study\\src\\test\\resources\\example.txt")), StandardCharsets.UTF_8);
        //List<String> words = Arrays.asList(contents.split("\\PL+"));
        //
        //long count = 0;
        //for (String word : words) {
        //    if (word.length()>12) count++;
        //}
        //System.out.println("for count=" + count);
        //
        //count = words.stream().filter(w->w.length()>12).count();
        //System.out.println("stream count=" + count);
        //
        //count = words.parallelStream().filter(w->w.length()>12).count();
        //System.out.println("parallelStream count=" + count);

        Stream<String> stringStream = Stream.generate(() -> "echo");
        System.out.println(stringStream.findAny().get());

        Stream<Double> randomDouble = Stream.generate(Math::random);
        System.out.println(randomDouble.findFirst().get());

        Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO,  n->n.add(BigInteger.ONE));
        for (int i = 0; i < 100; i++) {
            System.out.println(integerStream.findFirst().get());
        }
    }
}
