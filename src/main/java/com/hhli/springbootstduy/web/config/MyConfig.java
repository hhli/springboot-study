package com.hhli.springbootstduy.web.config;

import com.hhli.springbootstduy.other.ClientBean;
import com.hhli.springbootstduy.other.MyBeanRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary
 */
@Configuration
@Import(MyBeanRegistrar.class)
public class MyConfig {
    @Bean
    ClientBean clientBean () {
        return new ClientBean();
    }
}
