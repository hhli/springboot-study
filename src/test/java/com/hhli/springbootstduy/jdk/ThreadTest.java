package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2018/11/18 16:00
 * @description 线程测试
 */
class ThreadVolatileDemo extends Thread {
    public    boolean flag = true;
    @Override
    public void run() {
        System.out.println("开始执行子线程....");
        while (flag) {
            System.out.println("1111111"+flag);
        }
        System.out.println("线程停止");
    }

    public void setRuning(boolean flag) {
        this.flag = flag;
    }

}

/**
 *
 * @classDesc: 功能描述:(Volatile demo)
 * @author: zzq
 * @createTime: 2017年8月22日 下午10:34:05
 * @version: v1.0
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(3000);
        threadVolatileDemo.setRuning(false);
        System.out.println("flag 已经设置成false");
        Thread.sleep(1000);
        System.out.println(threadVolatileDemo.flag);

    }
}
