package com.hhli.springbootstduy.web.config;

import com.hhli.springbootstduy.dao.CompactDisc;
import com.hhli.springbootstduy.dao.impl.CDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by hhli_yangyu on 2018/10/6.
 *
 * @author hhli_yangyu
 * @summary
 */
//导入CDConfig的配置
@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {
    @Bean(name = "cDPlayer")
    public CDPlayer cdPlayer(CompactDisc heyGirl) {
    /* 这里注入的bean是上面CDConfig.java中的name为heyGirl的CompactDisc类型的bean*/
        return new CDPlayer(heyGirl);
    }

}