package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.ApplicationBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by hhli_yangyu on 2018/10/19.
 * @author hhli_yangyu
 * @summary
 */
@Slf4j
public class LogTest extends ApplicationBaseTest{

    @Test
    public void testIt(){
        try{
            test1();
        }catch (Exception e){
            log.error("111111111", e);
        }
    }

    public  void test1() throws Exception{
        test2();
    }


    public  void test2() throws Exception{
        Exception e = new Exception("test11111111111111");
        throw e;
    }
}
