package com.hhli.springbootstduy.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author 李辉辉
 * @date 2019/7/28 22:49
 * @description
 */
public class LocalDates {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        LocalDate alonzosBirthDay = LocalDate.of(1903, 6, 14);
        alonzosBirthDay = LocalDate.of(1903, Month.JUNE, 14);
        System.out.println("alonzosBirthDay:" + alonzosBirthDay);

        LocalDate independenceDay = LocalDate.of(2018, Month.JULY, 14);
        LocalDate christmas = LocalDate.of(2018, Month.DECEMBER, 25);
        System.out.println("until christmas:" + independenceDay.until(christmas, ChronoUnit.DAYS));

        System.out.println(LocalDate.of(2016, 1,31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3,31).plusMonths(1));

        DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1,1 ).getDayOfWeek();
        System.out.println("startOfLastMillennium: " + startOfLastMillennium);
        System.out.println(startOfLastMillennium.getValue());

        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }
}
