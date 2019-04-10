package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/9 22:39
 * @description 白色人种
 */
public class WhiteHuman implements Human{

    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的！");
    }

    @Override
    public void talk() {
        System.out.println("白色人种会说话，一般都是但是单字节。");
    }
}
