package com.hhli.springbootstduy.feign;

import com.hhli.springbootstduy.ApplicationBaseTest;
import com.hhli.springbootstduy.model.pojo.ParamPojo;
import com.hhli.springbootstduy.rest.GitHubRest;
import com.hhli.springbootstduy.rest.LocalApiRest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary restful接口调用测试
 * TODO 后续会增加拦截器的配置 用于签名，权限的校验
 * TODO 增加对接口超时以及重试等配置
 * TODO LocalDate的序列化问题
 * TODO x-www-form-url-encode的入参问题
 * TODO spring日志处理
 * TODO 增加到maven项目模板中
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
//        ParamPojo pojo = new ParamPojo(1L, "xiaoxhuihui");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 2L);
        paramMap.put("name", "xiaohuihui");
        System.out.println(apiRest.getBear(paramMap));
    }


    @Test
    public void testUploadFile() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("file", new File("C:\\Users\\hhli_yangyu\\Desktop\\47.pptx"));
        System.out.println(apiRest.getGrizzly(map));
    }
}
