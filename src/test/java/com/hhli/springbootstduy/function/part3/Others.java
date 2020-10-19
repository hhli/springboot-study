package com.hhli.springbootstduy.function.part3;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

/**
 * 基于三大基本型构的衍生型构
 * @author lizepu
 *
 * @param <T>
 * @param <U>
 * @param <R>
 */
public class Others<T,U,R> {
    /**
     * 基本类型簇
     */
    void basic() {
        IntConsumer ic;
        
        BooleanSupplier bs;
        
        LongFunction<T> lf;
        
        ToDoubleFunction<T> tdf;
        //exceptions:
        Predicate<T> pd;
    }
    
    /**
     * 二元参数簇
     */
    void bi() {
        BiConsumer<T,U> bic;
        
        BiFunction<T, U, R> bif;
        
        BiPredicate<T, U> bip;
    }
    
    /**
     * 运算符簇
     */
    void op() {
        Function<T,R> f;
        Function<T,T> f2;
        
        //是一个“单目运算符”，将一个类型运算后得到一个相同的类型；实际上，它继承了Function<T, T>；类比i++中的“++”；
        UnaryOperator<T> uo;

        //定义为(T,T) -> T;是一个“双目运算符”，同理，它继承了BiFunction<T,T,T>；类比1+1中的“+”；
        BinaryOperator<T> bo;
    }
    
    /**
     * 符合函数体簇
     */
    void complex() {
        DoubleBinaryOperator dbo;
        
        DoubleToLongFunction dtlf;
    }
    
    /**
     * 1.要求做到见明知型
     * 2.自定义函数式接口时，考虑尽量延用上述命名规范
     * 3.() -> ()
     */
    void futher() {
        
    }
}
