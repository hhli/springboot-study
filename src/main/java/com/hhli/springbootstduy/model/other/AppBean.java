package com.hhli.springbootstduy.model.other;

import lombok.Data;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
@Data
public class AppBean {
    private String str;

    public void process () {
        System.out.println(str);
    }
}