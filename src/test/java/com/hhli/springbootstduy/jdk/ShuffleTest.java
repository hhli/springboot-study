package com.hhli.springbootstduy.jdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2019/6/2 10:23
 * @description 混乱测试
 */
public class ShuffleTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);

        //Collections.copy();
    }
}
