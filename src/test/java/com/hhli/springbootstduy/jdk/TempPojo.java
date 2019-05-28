package com.hhli.springbootstduy.jdk;

import java.io.Serializable;

/**
 * @author 李辉辉
 * @date 2019-05-27 18:01
 * @description 临时pojo 用于测试
 */
public class TempPojo implements Serializable, Comparable {

    private static final long serialVersionUID = -8164127434372334567L;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
