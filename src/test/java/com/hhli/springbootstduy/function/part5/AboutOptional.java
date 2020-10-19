package com.hhli.springbootstduy.function.part5;

import java.util.Optional;
import java.util.Random;

/**
 * Optional本意为“可选的”这里引申为“可有可无的”，Optional<T> 定义了一个可有可无的T实例
 * 我们可以对T进行一系列操作，若在操作中的任何一个步骤T变为null，则终止操作；
 * 
 * @author lizepu
 *
 */
public class AboutOptional {
    /**
     * Optional 初始化
     */
    void opInit() {
        Optional<Integer> optionalInteger = Optional.ofNullable(1);
    }

    /**
     * Optional 变换
     */
    void opTransform() {
        // 构造Optional<Integer>
        Optional<Integer> optionalInteger = Optional.of(1);
        // 变换为Optional<String>
        Optional<String> optionalStr = optionalInteger.map(String::valueOf);

        // 构造包含随机Integer的Optional
        Optional<Integer> optionalRnd = Optional.of(new Random().nextInt());
        // 传入偶数断言，得到一个仅存在偶数的Optional
        Optional<Integer> optionalEven = optionalRnd.filter(i -> i % 2 == 0);
    }

    void opEnd() {
        // Optional.ifPresent
        Optional.of(new Random().nextInt()) // 获得一个包含随机数的Optional实例
                .filter(i -> i % 2 == 0) // 断言 使用传入的Predicate<T> 保证数据为偶数
                .map(String::valueOf) // 变换 使用传入的Function<T,R>变换类型(Integer -> String)
                .ifPresent(System.out::println); // 若满足条件则使用传入的Consumer<T>进行消费(打印)

        // Optional.orElse
        String evenStr = Optional.of(new Random().nextInt()) // 获得一个包含随机数的Optional实例
                .filter(i -> i % 2 == 0) // 变换数据为偶数
                .map(String::valueOf) // 变换类型为字符串
                .orElse("not even"); // 若不满足条件 则使用orElse传入的默认值

        // Optional.orElseGet
        String evenStrI = Optional.of(new Random().nextInt()) // 获得一个包含随机数的Optional实例
                .filter(i -> i % 2 == 0) // 变换数据为偶数
                .map(String::valueOf) // 变换类型为字符串
                .orElseGet(String::new); // 若不满足条件 则调用orElseGet传入的Supplier<T>获取一个默认值

        // Optional.orElseThrow
        String evenStrII = Optional.of(new Random().nextInt()) // 获得一个包含随机数的Optional实例
                .filter(i -> i % 2 == 0) // 变换数据为偶数
                .map(String::valueOf) // 变换类型为字符串
                .orElseThrow(RuntimeException::new); // 若不满足条件 则抛出一个异常
    }

    void example() {
        Optional.ofNullable(new House())
            .map(House::getUnit)
            .map(Unit::getBuilding)
            .map(Building::getResblock)
            .ifPresent(System.out::println);
    }

    static class House {
        Unit u;

        Unit getUnit() {
            return u;
        }
    }

    static class Unit {
        Building b;

        Building getBuilding() {
            return b;
        }
    }

    static class Building {
        Resblock r;

        Resblock getResblock() {
            return r;
        }
    }

    static class Resblock {
    }
}
