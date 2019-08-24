package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019/8/24 22:59
 * @description
 */
public enum BasicOperation implements Operation2{
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };
    private final String symbol;
    BasicOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return  symbol;
    }
}
