package com.hhli.springbootstduy.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *
 * run debug下线程数不一致
 * Monitor Ctrl-Break 理解时负责接受接收命令信号，dump线程信息
 * You can create a thread dump by invoking a control break (usually by pressing Ctrl-Break or Ctrl-\ or SIGQUIT on linux). This section provides information on working with thread dumps. It includes information on these subjects:
 * https://docs.oracle.com/cd/E13188_01/jrockit/docs50/userguide/apstkdmp.html
 * @author 李辉辉
 * @date 2019-03-10 11:21
 * @description 获取普通java进程包含的线程信息
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取java线程管理MBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor以及synchronizeor信息，仅仅获取线程技巧堆栈信息

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息
        for (ThreadInfo threadInfo : threadInfos) {
            //打印线程id以及线程名称
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }
}
