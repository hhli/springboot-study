package com.hhli.springbootstduy.feign;

import feign.Feign;
import feign.gson.GsonDecoder;
import org.junit.Test;

import java.util.List;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary restful接口调用测试
 */
public class RestTest {
    @Test
    public void feginRestTest(){
        GitHub gitHub = Feign.builder().decoder(new GsonDecoder()).target(GitHub.class, "https://api.github.com");

        List<Contributor> contributors = gitHub.contributors("OpenFeign", "feign");

        contributors.forEach(
                con-> System.out.println(new StringBuffer(con.getLogin()).append("(").append(con.getContributions()).append(")"))
        );
    }
}
