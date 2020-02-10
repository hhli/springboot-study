package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2020-02-10 21:21
 * @description
 */
public class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
