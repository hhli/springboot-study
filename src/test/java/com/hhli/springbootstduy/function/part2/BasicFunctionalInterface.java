package com.hhli.springbootstduy.function.part2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 三大基本型构
 * @author lizepu
 *
 * @param <T>
 * @param <R>
 */
public class BasicFunctionalInterface<T, R> {
    Supplier<T> s;
    Function<T, R> f;
    Consumer<R> c;
}
