package com.hhli.springbootstduy.forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * @author 李辉辉
 * @date 2019/2/18 15:36
 * @description 快速排序的fork任务
 */
public class SortTask extends RecursiveAction{

    private static final long serialVersionUID = 1721291035907952430L;

    final  long[] array;
    final int lo;
    final int hi;
    private int THRESOLD = 30;

    public  SortTask(long[] array){
        this.array = array;
        this.lo = 0;
        this.hi = this.array.length;
    }

    public SortTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }


    @Override
    protected void compute() {
        if(hi - lo < THRESOLD){
            sequentiallySort(array, lo, hi);
        }else{
           int pivot = partition(array, lo, hi);
        }
    }

    private  int partition(long[] array, int lo, int hi){
        long x = array[hi];
        int i = lo -1;
        for(int j = lo; j <hi; j++){
            if(array[j] <= x){
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i+1, hi);
        return  i + 1;
    }
    private void swap(long[] array, int i, int j){
        if(i != j){
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public void sequentiallySort(long[] array, int lo, int hi){
        Arrays.sort(array, lo ,hi);
    }
}
