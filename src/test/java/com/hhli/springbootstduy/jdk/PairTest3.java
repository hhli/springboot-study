package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019/5/28 8:46
 * @description
 */
public class PairTest3 {

    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 80000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 60000, 2003, 12, 15);

        ArrayAlg.Pair<Manager> buddies = new ArrayAlg.Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(100_0000);
        cfo.setBonus(50_0000);

        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();

        minMaxBonus(managers, result);
        System.out.println(
                "first:" + result.getFirst.getName() + ", second:" + result.getSecond.getName());

        maxMinBonus(managers, result);
        System.out.println(
                "first:" + result.getFirst.getName() + ", second:" + result.getSecond.getName());
    }
}

class PairAlg {
    public static boolean hasNull(ArrayAlg.Pair<>)
}

class ArrayAlg{
    public static class  Pair<T extends Comparable>{
        private T first;
        private T second;

        public Pair(T first, T second){
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        public static <T extends Comparable> Pair minMax(T[] values){
            if(values==null || values.length==0) return null;
            T min = values[0];
            T max = values[0];
            for (T value : values) {
                if(min.compareTo(value)>0)  min = value;
                if(max.compareTo(value)<0) max = value;
            }

            return new Pair(min, max);
        }
    }
}