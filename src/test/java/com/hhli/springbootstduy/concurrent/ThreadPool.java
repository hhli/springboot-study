package com.hhli.springbootstduy.concurrent;

/**
 * @author 李辉辉
 * @date 2019/3/16 15:49
 * @description
 */
public interface ThreadPool<Job extends Runnable> {
    //执行一个Job，这个Job需要实现runnable
    void execute(Job job);

    //关闭线程池
    void shutdown();

    // 增加工作者线程
    void addWorker(int num);

    //减少工作者线程
    void removeWorker(int num);

    //得到正在等待执行的任务数量
    int getJobSize();
}
