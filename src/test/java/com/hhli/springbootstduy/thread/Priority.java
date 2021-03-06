package com.hhli.springbootstduy.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2020/1/27 14:02
 * @description 优先级测试
 */
public class Priority {
    private static volatile  boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i <5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);

            Thread t = new Thread(job, "Thread:" + i);
            t.setPriority(priority);
            t.start();
        }

        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd  = false;

        for (Job job : jobs) {
            System.out.println("Job priority:" + job.priority + ", count=" + job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;

        public Job(int priority){
            this.priority = priority;
            this.jobCount = 0L;
        }
        @Override
        public void run() {
            while (notStart){
                Thread.yield();
            }

            while(notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }
}
