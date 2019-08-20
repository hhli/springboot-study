package com.hhli.springbootstduy.beancopy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 李辉辉
 * @date 2019/8/5 8:56
 * @description
 */
public class BasePojo2 implements Cloneable{

    private Date date = new Date();
     BasePojo2(){

    }
    @Override
    public BasePojo2 clone() throws CloneNotSupportedException {
        return (BasePojo2) super.clone();
    }

    public static void main(String[] args) {
        Set<BasePojo2> testSet = new TreeSet<>();
    }
}

class t1{

}

class t2{

}