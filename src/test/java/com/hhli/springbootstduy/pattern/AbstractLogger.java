package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2020-02-10 21:16
 * @description 抽象的记录器
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中下一个元素
    protected  AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level<=level){
            write(message);
        }

        if(nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
