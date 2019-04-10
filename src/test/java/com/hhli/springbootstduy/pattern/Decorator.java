package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/10 22:25
 * @description
 */
public class Decorator extends SchoolReport{
    private SchoolReport sr;
    public  Decorator(SchoolReport sr){
        this.sr = sr;
    }


    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
