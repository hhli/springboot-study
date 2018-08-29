package com.hhli.springbootstduy.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary
 */
@Configuration
@ConfigurationProperties(prefix = "project")
public class ProjectInfo {
    /** 项目版本号 **/
    private String version;

    /** 项目描述 **/
    private String description;
}
