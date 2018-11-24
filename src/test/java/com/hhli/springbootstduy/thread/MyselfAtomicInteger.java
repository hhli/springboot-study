package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2018/11/24 16:46
 * @description 线程安全的整型自增自减
 */

public class MyselfAtomicInteger {
    private  volatile  int i;

    public MyselfAtomicInteger(){

    }

    public MyselfAtomicInteger(int iTemp){
        this.i = iTemp;
    }

    public int incrementAndGet(){
        for(;;){
            int except = i + 1;
            if(i + 1 == except){
                i = except;
                return  except;
            }
        }
    }

    public int decrementAndGet(){
        for(;;){
            int except = i - 1;
            if(i - 1 == except){
                i = except;
                return  except;
            }
        }
    }
}
