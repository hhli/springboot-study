package com.hhli.springbootstduy.stream;

import org.apache.commons.lang.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author 李辉辉
 * @date 2019/7/20 15:56
 * @description 下游收集器测试
 */
public class DownStreamCollectors {
    public static  class City{
        private  String name;
        private String state;
        private int population;

        public City(String name, String state, int population){
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }


    }

    public static Stream<City> readCities(){
        return  Stream.of(
                new City("合肥", "安徽", 100),
                new City("亳州", "安徽", 10),
                new City("阜阳", "安徽", 80),
                new City("南京", "江苏", 200),
                new City("苏州", "江苏", 180),
                new City("上海", "上海", 880),
                new City("北京", "北京", 880),
                new City("郑州", "河南", 880)
        );
    }

    public static void main(String[] args) {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(Locale::getCountry, toSet()));
        System.out.println("countryToLocaleSet:" + countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCount = locales.collect(groupingBy(Locale::getCountry, counting()));
        System.out.println("countryToLocaleCount:" +  countryToLocaleCount);

        Stream<City> cities = readCities();
        Map<String, Integer> stateToCityPopulation = cities.collect(groupingBy(City::getState, summingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation:" + stateToCityPopulation);

        cities = readCities();
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(groupingBy(City::getState, mapping(City::getName, maxBy(
                Comparator.comparing(String::length)))));
        System.out.println("stateToLongestCityName:" + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(groupingBy(Locale::getCountry, mapping(Locale::getDisplayLanguage, toSet())));
        System.out.println("countryToLanguages:" + countryToLanguages);

        cities = readCities();
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
                groupingBy(City::getState, summarizingInt(City::getPopulation)));
        System.out.println("stateToCityPopulationSummary:" + stateToCityPopulationSummary.get("安徽"));

        cities = readCities();
        Map<String, String> stateToCityNames = cities.collect(groupingBy(City::getState, reducing(
                "", City::getName, (s, t)->s.length()==0? t: s + "," + t
        )));
        System.out.println("stateToCityNames:" + stateToCityNames);

        cities = readCities();
        stateToCityNames = cities.collect(groupingBy(City::getState, mapping(City::getName, joining(", "))));
        System.out.println("stateToCityNames:" + stateToCityNames);
    }
}