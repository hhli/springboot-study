package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019/10/20 15:37
 * @description CountDownLatch极端版本 effective不建议
 */
public class SlowCountDownLatch {
     private int count;

     public SlowCountDownLatch(int count){
         if(count<0) throw new IllegalArgumentException("count<0");
         this.count = count;
     }

     public void await(){
         while(true){
             synchronized (this){
                 if(count == 0) return;
             }
         }
     }

     public synchronized  void countDown(){
         if(count != 0) count--;
     }
}
