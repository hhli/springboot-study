package com.hhli.springbootstduy.other;

/**
 * @author 李辉辉
 * @date 2019/5/25 16:25
 * @description 静态内部类测试
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        ArrayAlg.Pair p = ArrayAlg.Pair.minMax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg{
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first, double second){
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public static  Pair minMax(double[] values){
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            for (double value : values) {
                if(min < value)  min = value;
                if(max > value) max = value;
            }

            return  new Pair(min, max);
        }
    }
}
