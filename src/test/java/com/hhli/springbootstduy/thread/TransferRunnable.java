package com.hhli.springbootstduy.thread;

/**
 * @author 李辉辉
 * @date 2019/7/14 2:21
 * @description 转账线程类
 */
public class TransferRunnable implements Runnable{
    private Bank bank;
    private int fromAccount;
    private double maxAccount;
    private int DELAY = 10;

    public TransferRunnable(Bank bank, int from , double max){
        this.bank = bank;
        this.fromAccount  = from;
        this.maxAccount = max;
    }
    @Override
    public void run() {
        try{
            while (true){
                int toAccount = (int)(bank.size() * Math.random());
                double amount = maxAccount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
