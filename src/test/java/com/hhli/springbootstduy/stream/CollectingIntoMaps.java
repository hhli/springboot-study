package com.hhli.springbootstduy.stream;

import lombok.ToString;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 李辉辉
 * @date 2019/7/20 12:43
 * @description 收集到map测试
 */
public class CollectingIntoMaps {
    public static class Person{
        private int id;
        private String name;

        public Person(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString(){
            return getClass().getName() + "[id=" +id + ",name=" + name + "]";
        }
    }

    public static Stream<Person> people(){
        return Stream.of(new Person(1001, "peter"), new Person(1002, "Paul"), new Person(1003, "Mary"));
    }

    public static void main(String[] args) {
        //Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        //System.out.println("idToName:" + idToName);
        //
        //Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        //System.out.println("idToPerson:" + idToPerson);
        //
        //idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity(), (oldValue, newValue)->{throw new IllegalStateException();}, TreeMap::new));
        //System.out.println("idToPerson:" + idToPerson.getClass().getName() + idToPerson);
        //
        //Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        //Map<String, String> languageNames = locales.collect(
        //  Collectors.toMap(
        //          Locale::getDisplayLanguage,
        //          l->l.getDisplayLanguage(l),
        //          (existingValue, newValue)->existingValue)
        //);
        //System.out.println("languageNames:" + languageNames);
        //
        //locales = Stream.of(Locale.getAvailableLocales());
        //Map<String, Set<String>> countryLanguageSets = locales.collect(
        //        Collectors.toMap(Locale::getDisplayCountry,
        //                l->Collections.singleton(l.getDisplayName()),
        //                (a, b)->{
        //                  Set<String> union = new HashSet<>(a);
        //                  union.addAll(b);
        //                  return union;
        //                })
        //);
        //
        //System.out.println("countryLanguageSet: " + countryLanguageSets);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocale = locales.collect(Collectors.groupingBy(Locale::getCountry));

        System.out.println(countryToLocale);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> en =
                locales.collect(Collectors.partitioningBy(l -> l.getLanguage().startsWith("en")));

        System.out.println(en.get(Boolean.TRUE));
    }
}
