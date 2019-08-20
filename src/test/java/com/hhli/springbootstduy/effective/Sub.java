package com.hhli.springbootstduy.effective;

import java.time.Instant;

/**
 * @author 李辉辉
 * @date 2019/8/14 9:12
 * @description
 */
public class Sub extends Super{
    private final Instant instant;

    public Sub(){
        //super();
        instant = Instant.now();
    }

    @Override
    public void overMe(){
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub  = new Sub();

        sub.overMe();
    }
}
