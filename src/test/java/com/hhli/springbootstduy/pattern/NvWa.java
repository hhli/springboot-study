package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/9 22:51
 * @description 女娲造人
 */
public class NvWa {

    public static void main(String[] args) {
        //声明阴阳八卦炉
        AbstractHumanFactory yinYangLu = new HumanFactory();

        //第一次造人，火候不足，于是白人产生了
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteMan = yinYangLu.createHuman(WhiteHuman.class);
        whiteMan.getColor();
        whiteMan.talk();

        //女娲第二次造人，火候过足，于是黑人产生了
        System.out.println("--造出的第二批人是白色人种--");
        Human blackMan = yinYangLu.createHuman(BlackHuMan.class);
        blackMan.getColor();
        blackMan.talk();

        //女娲第三次造人，火候刚好，于是黄种人产生了
        System.out.println("--造出的第三批人是黄色人种--");
        Human yellowMan = yinYangLu.createHuman(YellowHuman.class);
        yellowMan.getColor();
        yellowMan.talk();
    }
}
