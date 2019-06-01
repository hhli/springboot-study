package com.hhli.springbootstduy.jdk;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author 李辉辉
 * @date 2019/6/1 18:45
 * @description
 */
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem",  9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
