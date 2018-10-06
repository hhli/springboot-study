package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.model.other.AppBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by hhli_yangyu on 2018/10/6.
 * @author hhli_yangyu
 * @summary 自定义BeanRegistrar
 */
public class MyBeanRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(AppBean.class);
        gbd.getPropertyValues().add("str", "this is a test for ImportBeanDefinitionRegistrar");
        registry.registerBeanDefinition("appBean", gbd);
    }
}
