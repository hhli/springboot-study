package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2020-02-10 21:22
 * @description
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
