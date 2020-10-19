package com.hhli.springbootstduy.function.part4;

import java.io.PrintStream;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class AboutMethodReferance {
    public static void main(String[] args) {
        refStaticFromClass();
        refNonstaticFromInstance();
        refNonstaticFromClass();
    }

    /**
     * 从类型上引用静态函数
     */
    private static void refStaticFromClass() {
        // String -> Integer;
        Function<String, Integer> funcStoI = Integer::valueOf;

        // int -> int;
        IntUnaryOperator intUO = Math::abs;

        // (double,double) -> double;
        DoubleBinaryOperator doubleBO = Math::max;

        // 当然，构造方法也算一种特殊的静态函数
        // new String();
        Supplier<String> strSup = String::new;

        // new String(str);
        UnaryOperator<String> strUO = String::new;

        // 同理，数组的构造参数亦可
        // new int[x];
        IntFunction<int[]> intArray = int[]::new;
    }

    /**
     * 从实例上引用非静态函数
     */
    private static void refNonstaticFromInstance() {
        // () -> String
        Supplier<String> strSup = "WantString?"::toString;

        // () -> int
        Supplier<Integer> intSup = "WantSomeInt?"::hashCode;

        // String -> ()
        Consumer<String> strCons = System.out::println;
    }

    /**
     * 从类型上引用非静态方法，考虑等价关系
     */
    private static void refNonstaticFromClass() {
        // o.toString() <=> toString(o)
        Function<String, String> funcIII = String::toString;

        // o.hashCode() <=> hashCode(o)
        ToIntFunction<Object> toIntFunc = Object::hashCode;

        // r.run() <=> run(r)
        Consumer<Runnable> runCon = Runnable::run;

        // out.println(str) <=> println(out,str);
        BiConsumer<PrintStream, String> biCons = PrintStream::println;
    }

    static class Persion {
        String name;

        void say() {
            System.out.println("hello my name is :" + name);
        }
        
        static void say(Persion p) {
            System.out.println("hello my name is :" + p.name);
        }
    }
}
