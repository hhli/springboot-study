package com.hhli.springbootstduy.io;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/7/24 22:40
 * @description 正则表达式测试
 */
public class IoTest3 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3");
        stream.filter(Pattern.compile("").asPredicate());
    }
}
