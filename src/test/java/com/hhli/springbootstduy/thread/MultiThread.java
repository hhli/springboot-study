package com.hhli.springbootstduy.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author 李辉辉
 * @date 2020/1/27 13:38
 * @description 多线程测试
 */
public class MultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (ThreadInfo threadInfo : threadMXBean.dumpAllThreads(false, false)) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }
}
