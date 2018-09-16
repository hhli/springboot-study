package com.hhli.springbootstduy.feign;

import com.hhli.springbootstduy.ApplicationBaseTest;
import com.hhli.springbootstduy.model.pojo.ParamPojo;
import com.hhli.springbootstduy.rest.GitHubRest;
import com.hhli.springbootstduy.rest.LocalApiRest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.transform.Source;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary restful接口调用测试
 * TODO 后续会增加拦截器的配置 用于签名，权限的校验
 * TODO 增加对接口超时以及重试等配置
 */
public class FeignRestTest extends ApplicationBaseTest{
    @Autowired
    private GitHubRest hubRest;
    @Autowired
    private LocalApiRest apiRest;

    @Test
    public void testGitHub(){
        System.out.println(hubRest.contributors("OpenFeign", "feign"));
    }


    @Test
    public void testJson(){
        System.out.println(apiRest.getDolphin());
    }


    @Test
    public void testJson2(){
        ParamPojo pojo = new ParamPojo(1L, "xiaoxhuihui");
        System.out.println(apiRest.getPanda(pojo));
    }

    @Test
    public void testUrl(){
        ParamPojo pojo = new ParamPojo(1L, "xiaoxhuihui");
        System.out.println(apiRest.getUrlTest(pojo));
    }
}
