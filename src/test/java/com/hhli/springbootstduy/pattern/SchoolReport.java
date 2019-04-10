package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/10 22:09
 * @description 抽象成绩单
 */
public abstract  class SchoolReport {
    // 成绩单主要展示的是你的成绩情况
    public abstract void report();

    //成绩单要家长签字，这才是最要命的
    public abstract  void sign(String name);
}
