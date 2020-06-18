package com.hhli.springbootstduy.exception;

import com.hhli.springbootstduy.model.enums.CodeEnum;

/**
 * @author 李辉辉
 * @date 2020-06-17 17:32
 * @description
 */
public class CustomerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 异常的错误码
     */
    private final CodeEnum exceptionCodeEnum;

    /**
     * 异常的错误数据
     */
    private final transient Object data;

    /**
     * 抛出异常
     *
     * @param codeEnum
     * @author zhangdeman001@ke.com
     */
    public CustomerException(CodeEnum codeEnum, Object data) {
        super(codeEnum.getMessage());
        this.exceptionCodeEnum = codeEnum;
        this.data = data;
    }

    /**
     * 获取异常错误码
     *
     * @return
     */
    public CodeEnum getCodeEnum() {
        return this.exceptionCodeEnum;
    }

    /**
     * 获取异常的数据
     *
     * @return
     * @author zhangdeman001@ke.com
     */
    public Object getData() {
        return this.data;
    }
}

