package com.hhli.springbootstduy.model.other;

import lombok.Data;

/**
 * @author 李辉辉
 * @date 2018/12/30 15:49
 * @description oom大对象
 */
@Data
public class OOMObject {

    private String[] str = new String[10000];
}
