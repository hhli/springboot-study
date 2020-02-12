package com.hhli.springbootstduy.web.controller;

import com.hhli.springbootstduy.model.vo.ResultDataVo;
import com.hhli.springbootstduy.web.BaseController;
import com.hhli.springbootstduy.web.config.ProjectInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary 用于测试服务是否正常
 */
@RestController
@Slf4j
public class PingController extends BaseController {
    @Autowired
    private ProjectInfo projectInfo;

    /**
     *
     * @return
     */
    @GetMapping(value={"/", "/it/ping"})
    public ResultDataVo testIt(){
        log.info("11");
        return getSuccessResp(projectInfo);
    }
}
