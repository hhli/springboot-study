package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019-09-29 18:51
 * @description 克隆测试
 */
public class CloneableTest implements Cloneable{

    public CloneableTest clone(){
        return  new CloneableTest();
    }
}
