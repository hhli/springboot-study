package com.hhli.springbootstduy.model.other;

/**
 * @author 李辉辉
 * @date 2018/12/30 17:52
 * @description jvm stack over flow测试
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        Long[] longArray = new Long[10000];
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + sof.stackLength);
            throw  e;
        }
    }
}
