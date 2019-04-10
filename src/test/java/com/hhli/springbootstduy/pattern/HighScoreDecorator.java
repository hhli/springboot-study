package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/10 22:27
 * @description 最高成绩修饰
 */
public class HighScoreDecorator extends Decorator{

    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportHighScore(){
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }
}
