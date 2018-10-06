package com.hhli.springbootstduy.model.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by hhli_yangyu on 2018/10/5.
 * @author hhli_yangyu
 * @summary 自定义注解进行扫描
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyComponent {
}
