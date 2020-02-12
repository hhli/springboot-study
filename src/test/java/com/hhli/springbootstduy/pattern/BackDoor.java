package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 8:44
 * @description 乔国老开后门
 */
public class BackDoor implements IStrategy{

    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 110; i++) {
            sb.append(i).append(",");
        }

        System.out.println(sb);
    }
}
