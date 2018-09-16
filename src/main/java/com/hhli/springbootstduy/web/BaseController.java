package com.hhli.springbootstduy.web;

import com.hhli.springbootstduy.model.enums.RetCodeEnum;
import com.hhli.springbootstduy.model.vo.ResultDataVo;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary controller基类
 */
public class BaseController {

    public ResultDataVo getSuccessResp(Object object){
        ResultDataVo vo = new ResultDataVo();
        vo.setCode(RetCodeEnum.SUCCESS.getCode());
        vo.setMessage("请求成功");
        vo.setData(object);
        return vo;
    }
}
