package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/9 22:05
 * @description 黄色人种
 */
public class YellowHuman implements Human{

    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的！");
    }

    @Override
    public void talk() {
        System.out.println("黄种人会说话，一般说的都是双字节");
    }

}
