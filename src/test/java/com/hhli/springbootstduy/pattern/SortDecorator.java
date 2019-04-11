package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/10 22:29
 * @description
 */
public class SortDecorator extends Decorator{

    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportSort(){
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report(){
        super.report();
        this.reportSort();
    }
}
