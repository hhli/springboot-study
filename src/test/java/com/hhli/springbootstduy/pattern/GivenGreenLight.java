package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2019/4/16 8:46
 * @description 吴国太开绿灯
 */
public class GivenGreenLight implements IStrategy{

    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯，放行！s");
    }
}
