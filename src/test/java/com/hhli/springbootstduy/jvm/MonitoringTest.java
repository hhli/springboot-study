package com.hhli.springbootstduy.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 李辉辉
 * @date 2019/1/6 20:55
 * @description jconsole测试
 */
public class MonitoringTest {

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
    }
    static  class  OOMObject{
        public  byte[] placeHolder = new byte[64 * 1024];
    }

    public static  void fillHeap(int num) throws InterruptedException {
        List<OOMObject> objectList = new ArrayList<>();
        for(int i = 0; i<num; i++){
            // 稍作延迟，让监视曲线的变化更加明显
            Thread.sleep(50);
            objectList.add(new OOMObject());
            System.out.println("--------------" + i);
        }

        System.gc();
    }
}
