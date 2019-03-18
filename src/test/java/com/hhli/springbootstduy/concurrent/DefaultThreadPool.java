package com.hhli.springbootstduy.concurrent;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 李辉辉
 * @date 2019/3/16 15:54
 * @description
 */
public class  DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static  final int MAX_WORKER_NUMBERS = 10;
    //线程池默认的数量
    public static final int DEFAULT_WORKER_NUMBERS= 5;
    //线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;

    //这是一个工作列表，将会向里插入工作
    private  final LinkedList<Job> jobs = new LinkedList<>();

    //工作者列表
    private final List<Worker> workers  = Collections.synchronizedList(new ArrayList<>());
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notifyAll();
            }
        }

    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs){
            if(num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }

            initializeWorkers(num);
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num > this.workerNum){
                throw new IllegalArgumentException("beyond work num");
            }

            int count = 0;
            while (count <num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
                this.workerNum -=count;
            }
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initializeWorkers(int num){
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }

    }

    class Worker implements Runnable{
        private volatile  boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        job = jobs.removeFirst();
                    }
                }
                if(job != null){
                    try{
                        job.run();
                    }catch (Exception e){
                        //忽略job运行过程中的exception
                    }
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }

}
