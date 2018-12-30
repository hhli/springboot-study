package com.hhli.springbootstduy.model.other;

/**
 * @author 李辉辉
 * @date 2018/12/30 18:08
 * @description java栈区oom测试
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public  void statckLeakByThread(){
        while (true) {
            new Thread(() -> {
                dontStop();
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.statckLeakByThread();
    }
}
