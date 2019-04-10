package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/9 22:01
 * @description 黑色人种
 */
public class BlackHuMan implements Human{

    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的！");
    }

    @Override
    public void talk() {
        System.out.println("黑人会说话，一般人听不懂。");
    }
}
