package com.hhli.springbootstduy.jvm;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

/**
 * @author 李辉辉
 * @date 2019/1/7 9:44
 * @description
 */
public class TraceMethodArgsAndReturn {
    @OnMethod(
            clazz="com.hhli.springbootstduy.jvm.StringTableTest",
            method="intern",
            location=@Location(Kind.RETURN)
    )
    public static void traceExecute(int sSrc,@Return long result){
        println("invoke StringTableTest.intern");
        println(strcat("input arg is:", str(sSrc)));
        // 打印函数返回结果result
        println(strcat("result is:",str(result)));
        //打印方法执行时间点
        println(strcat("time is:",str(timeMillis())));
        //打印线程堆栈
        jstack();
    }
    @OnMethod(
            clazz="com.hhli.springbootstduy.jvm.StringTableTest",
            location=@Location(value= Kind.LINE,line=22)
    )
    public static void traceExecute(@ProbeClassName String pcn,@ProbeMethodName String pmn,int line){
        println(strcat(strcat(strcat("call ",pcn),"."),pmn));
    }
}

