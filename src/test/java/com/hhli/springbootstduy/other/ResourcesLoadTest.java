package com.hhli.springbootstduy.other;

import java.io.File;
import java.io.IOException;

/**
 * @author 李辉辉
 * @date 2019-10-22 11:48
 * @description 资源加载测试
 */
public class ResourcesLoadTest {

    public static void main(String[] args) throws IOException {
        ResourcesLoadTest test = new ResourcesLoadTest();
        test.getClassPath();
        test.testDirectory();
        test.testClassPath2();
    }

    public void getClassPath() {
        /**
         * 关于两者的区别
         * https://blog.csdn.net/zhangshk_/article/details/82704010
         * https://blog.csdn.net/c315838651/article/details/71915742
         */
        System.out.println(this.getClass().getClassLoader().getResource("example.txt").getPath());
        //存在npe的问题
        //System.out.println(this.getClass().getResource("example.txt").getPath());
    }


    public void testDirectory() throws IOException {
        File file = new File("");
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getAbsolutePath());
    }

    public void testClassPath2(){
        System.out.println(this.getClass().getResource("/"));
    }


}
