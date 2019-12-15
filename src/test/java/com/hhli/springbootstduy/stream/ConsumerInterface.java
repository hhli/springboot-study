package com.hhli.springbootstduy.stream;

/**
 * @author 李辉辉
 * @date 2019/12/15 16:12
 * @description
 */
@FunctionalInterface
public interface ConsumerInterface<T> {
    void accept(T t);
}
