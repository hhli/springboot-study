package com.hhli.springbootstduy.web.controller;

import com.hhli.springbootstduy.model.enums.RetCodeEnum;
import com.hhli.springbootstduy.model.vo.ResultDataVo;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary controller基类
 */
public class BaseController {

    public ResultDataVo getResp(Object obj){
        ResultDataVo result = new ResultDataVo();
        result.setCode(RetCodeEnum.SUCCESS.getCode());
        result.setMessage("");
        result.setData(obj);
        return  result;
    }
}
