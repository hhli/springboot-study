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

        ArrayAlg.Pair<Employee> result = new ArrayAlg.Pair<>();

        minMaxBonus(managers, result);
        System.out.println(
                "first:" + result.getFirst().getName() + ", second:" + result.getSecond().getName());

        maxMinBonus(managers, result);
        System.out.println(
                "first:" + result.getFirst().getName() + ", second:" + result.getSecond().getName());
    }

    public static void printBuddies(ArrayAlg.Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }


    public static void minMaxBonus(Manager[] a, ArrayAlg.Pair<? super Manager> result){
        if(a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 0; i < a.length; i++) {
            if(min.getBonus()>a[i].getBonus()) min = a[i];
            if(max.getBonus()<a[i].getBonus()) max = a[i];
        }

        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxMinBonus(Manager[] a, ArrayAlg.Pair<? super Manager> result){
        minMaxBonus(a, result);
        PairAlg.swapHeleper(result);
    }
}


class PairAlg {
    public static boolean hasNull(ArrayAlg.Pair<?> p){
        return  p.getFirst()!=null || p.getSecond()!=null;
    }

    public static <T> void swapHeleper(ArrayAlg.Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}