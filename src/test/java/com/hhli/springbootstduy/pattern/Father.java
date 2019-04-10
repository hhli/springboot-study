package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/10 22:19
 * @description
 */
public class Father {

    public static void main(String[] args) {
        //SchoolReport report = new SugarFouthGradeSchoolReport();
        //report.report();
        //report.sign("老三");

        SchoolReport sr = new FouthGradeSchoolReport();
        sr = new HighScoreDecorator(sr);
        sr = new SortDecorator(sr);
        sr.report();
        sr.sign("老三");
    }
}
