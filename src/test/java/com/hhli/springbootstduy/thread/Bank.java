package com.hhli.springbootstduy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李辉辉
 * @date 2019/7/14 2:13
 * @description 转账银行类
 */
public class Bank {
    private  final double[] accounts;
    //private Lock lock;
    //private Condition sufficientFunds;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
        //lock = new ReentrantLock();
        //sufficientFunds = lock.newCondition();
    }

    public synchronized  void transfer(int from, int to, double account) throws InterruptedException {
        try{
            //lock.lock();
            while (accounts[from] < account){
                //sufficientFunds.await();
                wait();
            }

            System.out.print(Thread.currentThread());

            accounts[from] -= account;
            System.out.printf("%10.2f from %d to %d", account, from, to);
            accounts[to] += account;

            System.out.printf("Total Balance: %10.2f%n", getBalance());

            notifyAll();
            //sufficientFunds.signalAll();
        }finally {
            //lock.unlock();
        }
    }

    public synchronized  double getBalance(){
        //lock.lock();
        try{
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }

            return sum;
        }finally {
            //lock.unlock();
        }
    }


    public int size(){
        return  accounts.length;
    }
}
