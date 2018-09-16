package com.hhli.springbootstduy.web.config;

import feign.Contract;
import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hhli_yangyu on 2018/9/16.
 * @author hhli_yangyu
 * @summary
 */
@Configuration
public class FeignConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;


    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }


    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }

//    /**
//     * 开启feign-core的注解
//     * @return
//     */
//    @Bean
//    public Contract useFeignAnnotations() {
//        return new Contract.Default();
//    }
}
