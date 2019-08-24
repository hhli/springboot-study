package com.hhli.springbootstduy.effective;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author 李辉辉
 * @date 2019/8/24 23:04
 * @description
 */
public enum  ExtendedOperation implements Operation2{
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x%y;
        }
    };


    private final String symbol;
    ExtendedOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return  symbol;
    }

    public static void main(String[] args) {
        double x = 4.00000000;
        double y = 2.00000000;

        test(ExtendedOperation.class, x, y);
        System.out.println("===================");
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static  <T extends Enum<T> & Operation2> void test(Class<T> operType, double x, double y){
        for (Operation2 t : operType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, t, y , t.apply(x, y));
        }
    }

    private static  void test(Collection<? extends Operation2> opSet, double x, double y){
        for (Operation2 operation2 : opSet) {
            System.out.printf("%f %s %f = %f%n", x, operation2, y , operation2.apply(x, y));
        }
    }
}
