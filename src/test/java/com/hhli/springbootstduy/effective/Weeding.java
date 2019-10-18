package com.hhli.springbootstduy.effective;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 李辉辉
 * @date 2019-10-10 16:42
 * @description 结婚日期
 */
@Data
public class Weeding implements Serializable, Cloneable {

    private static final long serialVersionUID = -6758111586439605360L;


    final private Date date;

    public  Weeding(Date date){
        this.date = date;
    }


    @Override
    public Weeding clone() throws CloneNotSupportedException {
        return (Weeding) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //Weeding weeding = new Weeding(new Date());
        //
        //System.out.println(weeding.clone().getDate() == weeding.getDate());


        //Lists.newArrayList("11", "2", "3");

        //String s1 = "O";
        //System.out.println((int)s1.charAt(0));
        //System.out.println((int)s1.charAt(1));

        Set<String> strSet = new LinkedHashSet<>();

        strSet.add("3");
        strSet.add("2");
        strSet.add("1");

        strSet.forEach(System.out::println);

    }
}
