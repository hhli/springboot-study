package com.hhli.springbootstduy.web.controller;

import com.hhli.springbootstduy.model.pojo.ParamPojo;
import com.hhli.springbootstduy.model.vo.MockApiVo;
import com.hhli.springbootstduy.model.vo.ResultDataVo;
import com.hhli.springbootstduy.web.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by hhli_yangyu on 2018/9/16.
 * @author hhli_yangyu
 * @summary api接口测试
 */
@RestController
@Slf4j
public class TestController extends BaseController {
    /**
     *
     * @return
     */
    @PostMapping("/dolphin")
    public String getDolphin(){

        return  "我是一只可爱的海豚";
    }

    @PostMapping("/panda")
    public ResultDataVo getPanda(@RequestBody ParamPojo paramPojo){
        log.info("params are:{}", paramPojo);

        return getSuccessResp("我是熊猫，喜欢发呆，喜欢玩手机~~");
    }

    @PostMapping("/bear")
    public MockApiVo getBear(ParamPojo pojo){
        log.info("params are:{}", pojo);

        MockApiVo vo = new MockApiVo();
        vo.setId(1L);
        vo.setCreatedAt(new Date());
        vo.setName("白熊");
        vo.setAvatar("我是白熊，虽然我很沉默，但是我很温柔，并且无所不能~~");

        return  vo;
    }

    @PostMapping(value = "/grizzly")
    public ResultDataVo uploadFile(MultipartFile file){
        log.info("file name is:{}", file.getOriginalFilename());

        return  getSuccessResp(file.getOriginalFilename());
    }
}
