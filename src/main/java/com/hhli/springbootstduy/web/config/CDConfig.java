package com.hhli.springbootstduy.web.config;

import com.hhli.springbootstduy.dao.CompactDisc;
import com.hhli.springbootstduy.dao.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
// @Configuration注解表示定义一个配置类
@Configuration
public class CDConfig {
    // 方法名heyGirl即是bean的name
    // 将SgtPeppers注册为 SpringContext中的bean
    @Bean
    public CompactDisc heyGirl() {
        // CompactDisc类型的
        return new SgtPeppers();
    }
}