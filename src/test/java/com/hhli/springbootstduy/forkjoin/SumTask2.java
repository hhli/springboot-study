package com.hhli.springbootstduy.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 李辉辉
 * @date 2019/2/18 17:31
 * @description
 */
public  class SumTask2 extends RecursiveTask<Long> {
    private static final long serialVersionUID = -6727595050950230424L;

    static final int THRESHOLD = 100;

    long[] array;
    int start;
    int end;

    SumTask2(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(String.format("compute %d~%d = %d", start, end, sum));
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask2 subtask1 = new SumTask2(this.array, start, middle);
        SumTask2 subtask2 = new SumTask2(this.array, middle, end);
        invokeAll(subtask1, subtask2);

        subtask1.fork();
        subtask2.fork();

        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }


    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[400];
        for (int i = 0; i < 400; i++) {
            array[i]  = 1;
        }
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(2); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask2(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }
}
