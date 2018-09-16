package com.hhli.springbootstduy.rest;

import com.hhli.springbootstduy.model.pojo.ParamPojo;
import com.hhli.springbootstduy.model.vo.MockApiVo;
import com.hhli.springbootstduy.model.vo.ResultDataVo;
import com.hhli.springbootstduy.web.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hhli_yangyu on 2018/9/16.
 * @author hhli_yangyu
 * @summary 本地api测试
 */
@FeignClient(value = "test-service", url = "${local.server}", configuration = FeignConfig.class)
public interface LocalApiRest {
    /**
     *  json测试
     * @return
     */
    @RequestMapping(value="/dolphin", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    String getDolphin();

    /**
     * json测试2
     * @param pojo  测试参数
     * @return
     */
    @RequestMapping(value="/panda", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResultDataVo getPanda(ParamPojo pojo);



    /**
     * json测试2
     * @param pojo  测试参数
     * @return
     */
    @RequestMapping(value="/bear", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    MockApiVo  getUrlTest(ParamPojo pojo);
}
