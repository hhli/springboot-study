package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/7/14 2:09
 * @description 线程非安全性测试
 */
public class UnsafeBankTest {
    public  static final int NACCOUNTS  = 20;
    public static  final int INITIAL_BALANCE  = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, 2 * INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
