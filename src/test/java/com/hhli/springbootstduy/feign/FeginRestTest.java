package com.hhli.springbootstduy.feign;

import com.hhli.springbootstduy.ApplicationBaseTest;
import com.hhli.springbootstduy.rest.GitHubRest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary restful接口调用测试
 */
public class FeginRestTest extends ApplicationBaseTest{
    @Autowired
    private GitHubRest hubRest;

    @Test
    public void testGitHub(){
        System.out.println(hubRest.contributors("OpenFeign", "feign"));
    }
}
