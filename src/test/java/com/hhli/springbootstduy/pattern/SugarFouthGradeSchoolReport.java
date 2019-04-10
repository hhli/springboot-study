package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/10 22:16
 * @description 包装后的成绩单
 */
public class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport{
    private void reportHighScore(){
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }


    private void reportSort(){
        System.out.println("我是排名38名......");
    }

    @Override
    public void report(){
        reportHighScore();
        super.report();
        this.reportSort();
    }


}
