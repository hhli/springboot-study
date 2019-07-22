package com.hhli.springbootstduy.other;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author 李辉辉
 * @date 2019-07-18 12:53
 * @description
 */
public class StreamTest {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/lihuihui/Documents/study/springboot-study/src/test/resources/example.txt";
        String contents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);

        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Optional<String> optionalValue = words.stream().filter(s->s.contains("fred")).findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result:" + result);
        result = optionalString.orElseGet(()-> Locale.getDefault().getDisplayName());
        System.out.println("result:" + result);

        try{
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result:" + result);
        }catch (Throwable e){
            e.printStackTrace();
        }

        optionalValue = words.stream().filter(s->s.contains("标准")).findFirst();
        optionalValue.ifPresent(s-> System.out.println(s + " contains 标准"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added  = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(StreamTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(StreamTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(StreamTest::squareRoot));


        Optional<Double> result2 = Optional.of(-4.0).flatMap(StreamTest::inverse).flatMap(StreamTest::squareRoot);
        System.out.println(result2);

    }


    public static Optional<Double> inverse(Double x){
        return  x == 0 ? Optional.empty() : Optional.of(1/x);
    }

    public static Optional<Double> squareRoot(Double x){
        return  x< 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
