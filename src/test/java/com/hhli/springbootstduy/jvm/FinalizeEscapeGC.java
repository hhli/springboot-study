package com.hhli.springbootstduy.jvm;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2018/12/30 21:33
 * @description  gc测试
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yeah, I' am still alive :)");
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功解救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(Objects.nonNull(SAVE_HOOK)){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("I am dead~~~~");
        }

        //对象第一次成功解救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(Objects.nonNull(SAVE_HOOK)){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("I am dead~~~~");
        }

    }

}
