package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019-05-27 17:41
 * @description
 */
public class PairTest2 {

    public static void main(String[] args) {
        //LocalDate[] birthdays = {
        //        LocalDate.of(1906,12, 9),
        //        LocalDate.of(1815,12, 10),
        //        LocalDate.of(1903, 12,1),
        //        LocalDate.of(1910, 6, 22)
        //};
        //
        //ArrayAlg.Pair<LocalDate> pairs = ArrayAlg.minMax(birthdays);
        ////ArrayAlg.Pair<TempPojo> pairs = ArrayAlg.minMax(new TempPojo[3]);
        //System.out.println("min=" + pairs.getFirst());
        //System.out.println("max=" + pairs.getSecond());

        int num =0;
        for (int i = 0; i < 100; i++) {
            num = num++;
        }
        System.out.println(num);
        System.out.println(num++);
    }
}

class ArrayAlg{
    public static class Pair<T> {

        private T first;

        private T second;

        public Pair(){

        }

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public void setSecond(T second) {
            this.second = second;
        }
    }

    public static  <T extends Comparable> Pair<T> minMax(T[] a){
            if(a == null || a.length == 0) return  null;
            T min = a[0];
            T max = a[0];
        for (T t : a) {
           if(t.compareTo(min)<0) min = t;
           if(t.compareTo(max)>0) max = t;
        }

        return new Pair<>(min, max);
    }
}
