package com.hhli.springbootstduy.rest;

import com.hhli.springbootstduy.model.pojo.ParamPojo;
import com.hhli.springbootstduy.model.vo.MockApiVo;
import com.hhli.springbootstduy.model.vo.ResultDataVo;
import com.hhli.springbootstduy.web.config.FeignConfig;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.util.Map;

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
    @PostMapping(value="/dolphin", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    String getDolphin();

    /**
     * json测试2
     * @param pojo  测试参数
     * @return
     */
    @PostMapping(value="/panda", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResultDataVo getPanda(ParamPojo pojo);



    /**
     * json测试2
     * @param queryParam  测试参数
     * @return
     */
    @PostMapping(value="/bear", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    MockApiVo getBear(Map<String, ?> queryParam);

    /**
     * 文件上传测试
     * @param queryParam
     * @return
     */
    @PostMapping(value="/grizzly", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResultDataVo getGrizzly(Map<String, ?> queryParam);
}
