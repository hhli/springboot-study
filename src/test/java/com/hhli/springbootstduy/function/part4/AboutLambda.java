package com.hhli.springbootstduy.function.part4;

import java.io.Serializable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * lambda是函数式接口实现的简化方式
 * @author lizepu
 *
 */
public class AboutLambda {
    public static void main(String[] args) {
        // Lambda由小括号组成的参数列表、箭头符号"->"、主体逻辑 三部分组成
        Supplier<String> sup = () -> {
            return "HelloWorld";
        };
 
        Function<Object,String> func = (o) -> {
            return o.toString();
        };
        
        // 当Lambda只有一个参数时，小括号可以省略
        Function<Object,String> funI = o -> {
            return o.toString();
        };
        
        // 当主体结构只有一行语句时，大括号和语句结尾的分号可以省略，如果是return语句，则return可以省略
        Function<Object,String> funII = o -> o.toString();
 
        // 当需要匹配多个接口类型时（尤其是标签接口）使用&指明其类型
        Runnable r = (Runnable & Serializable) () -> {};
        System.out.println(Serializable.class.isInstance(r)); // true
    }
}
