package com.hhli.springbootstduy.jdk;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author 李辉辉
 * @date 2018/11/20 8:51
 * @description 日期测试
 */
public class CalendarTest {

    public static void main(String[] args) {
        //construct d as current date
        GregorianCalendar d = new GregorianCalendar();

        int today = d.get(Calendar.DAY_OF_MONTH);
        int moth = d.get(Calendar.MONTH);

        //set d to start date of month
        d.set(Calendar.DAY_OF_MONTH, 1);

        int weekday = d.get(Calendar.DAY_OF_WEEK);


        //get first day of week(Sunday in U.S)
        int firstDayOfWeek = d.getFirstDayOfWeek();

        //determine the required indentation for the first line;
        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH, -1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        //print weekday names
        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do{
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_WEEK, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }while (weekday != firstDayOfWeek);

        System.out.println();

        for(int i=0; i<indent; i++){
            System.out.printf(" ");
        }

        d.set(Calendar.DAY_OF_MONTH, 1);

        do{
            //print day
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",  day);

            //mark current day with *;
            if (day == today) {
                System.out.print("*");
            }
            else {
                System.out.print("  ");
            }

            // advance d  to next day
            d.add(Calendar.DAY_OF_MONTH, 1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            //start a new line at the start of the week
            if(weekday == firstDayOfWeek){
                System.out.println();
            }
        }while (moth == d.get(Calendar.MONTH));
    }
}
