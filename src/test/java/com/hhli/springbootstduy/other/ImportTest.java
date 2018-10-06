package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.ApplicationBaseTest;
import com.hhli.springbootstduy.dao.impl.CDPlayer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary  @import test
 */
public class ImportTest extends ApplicationBaseTest{

    @Autowired
    private CDPlayer cdPlayer;
    @Autowired
    private ClientBean clientBean;

    @Test
    public void testIt(){
        cdPlayer.play();
    }


    @Test
    public void testImportBeanRegistrar(){
        clientBean.doSomething();
    }
}
