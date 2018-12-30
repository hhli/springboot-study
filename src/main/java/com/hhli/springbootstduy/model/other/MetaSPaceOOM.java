package com.hhli.springbootstduy.model.other;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author 李辉辉
 * @date 2018/12/30 18:34
 * @description 元数据空间溢出测试
 */
public class MetaSPaceOOM {

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));

            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
