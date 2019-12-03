package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019-11-13 20:44
 * @description
 */
public class HashCodeTest {

    public static void main(String[] args) {
        //new Thread(()-> System.out.println(new TempSon().hashCode())).start();
        //new Thread(()-> System.out.println(new TempSon().hashCode())).start();
        //
        //System.out.println(new TempSon().hashCode());
        //System.out.println(new TempSon().hashCode());
        //
        //
        Son s1 = new Son();
        s1.setId(1L);
        Son s2 = new Son();
        s2.setId(1L);
        System.out.println(s1.hashCode() + ":" + s2.hashCode());

        //Father f1  = new Father();
        //f1.setId(1L);
        //Father f2 = new Father();
        //f2.setId(1L);
        //
        //System.out.println(f1.hashCode() + ":" + f2.hashCode());
        //
        //System.out.println(System.identityHashCode(f1) + ":" + System.identityHashCode(f2));
    }
}
