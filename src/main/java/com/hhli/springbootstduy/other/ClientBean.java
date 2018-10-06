package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.model.other.AppBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
public class ClientBean {
    @Autowired
    private AppBean appBean;

    public void doSomething () {
        appBean.process();
    }
}
