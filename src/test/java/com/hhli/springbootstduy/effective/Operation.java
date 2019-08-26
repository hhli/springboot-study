package com.hhli.springbootstduy.effective;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/8/24 11:07
 * @description 运算符枚举
 */
public enum Operation {

    PLUS("+", (x, y)-> x+y),
    //        {
    //    @Override
    //    public double apply(double x, double y) {
    //        return x+y;
    //    }
    //},
    MINUS("-", (x, y)-> x-y),
    //        {
    //    @Override
    //    //public double apply(double x , double y){
    //    //    return  x-y;
    //    //}
    //},
    TIMES("*", (x, y)->x*y) ,
    //        {
    //    @Override
    //    public double apply(double x, double y) {
    //        return x*y;
    //    }
    //},
    DIVIDE("/", (x, y)->x/y) ;
            //{
    //    @Override
    //    public double apply(double x, double y) {
    //        return x/y;
    //    }
    //};


    private final String symbol;
    private final DoubleBinaryOperator op;
    Operation(String symbol, DoubleBinaryOperator op){
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString(){
        return  symbol;
    }
    //public abstract double apply(double x, double y);
    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }


    private static final Map<String, Operation> tempMap = new HashMap<>();
    private static final Map<String, Operation> stringToEnum = Stream.of(Operation.values()).collect(
            Collectors.toMap(Operation::toString, e->e));

    public static Optional<Operation> formString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        double x = 2.0000000;
        double y = 4.0000000;

        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f =%f%n",  x, operation, y, operation.apply(x, y));
        }

        System.out.println(Operation.valueOf("PLUS"));

        EnumSet<Operation> enumSet = EnumSet.of(Operation.PLUS);
    }
}
