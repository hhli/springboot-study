package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019/8/24 10:37
 * @description apple的品种枚举
 */
public enum Apple {
    FUJI,
    PIPPIN,
    GRANNY_SMITH;

    public static void main(String[] args) {
        System.out.println(Apple.FUJI.ordinal());
    }
}
