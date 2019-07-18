package com.hhli.springbootstduy.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/7/16 8:53
 * @description 用stream的形式统计单词
 */
public class CountLongWords {

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if(i>0) System.out.println(", ");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else {
                System.out.print(".....");
            }
        }

        System.out.println();
    }
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
        //
        //Stream<String> stringStream = Stream.generate(() -> "echo");
        //System.out.println(stringStream.findAny().get());
        //
        //Stream<Double> randomDouble = Stream.generate(Math::random);
        //System.out.println(randomDouble.findFirst().get());
        //
        //Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO,  n->n.add(BigInteger.ONE));
        //for (int i = 0; i < 100; i++) {
        //    System.out.println(integerStream.findFirst().get());
        //}

        Path path = Paths.get("D:\\github\\springboot-study\\src\\test\\resources\\example.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);

        Stream<String> song = Stream.of("gently", "dow", "the", "stream");
        show("songs", song);

        Stream<String> silence = Stream.empty();
        show("silence", silence);

        Stream<String> generate = Stream.generate(()->"echo");
        show("echo", generate);

        Stream<Double> random = Stream.generate(Math::random);
        show("random", random);

        Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE));
        show("integer", integerStream);

        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);

        try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
            show("lines", lines);
        }
    }
}
