package com.hhli.springbootstduy.jvm;

import com.hhli.springbootstduy.model.other.OOMObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李辉辉
 * @date 2018/12/30 15:48
 * @description 堆oom测试
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> objectList = new ArrayList<>();

        while (Boolean.TRUE){
            objectList.add(new OOMObject());
        }

        System.out.println("done");
    }
}
