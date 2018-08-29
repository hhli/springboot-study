package com.hhli.springbootstduy.model.exception;

import com.hhli.springbootstduy.model.enums.RetCodeEnum;
import lombok.Data;

/**
 * Created by hhli_yangyu on 2018/3/22.
 * @author hhli_yangyu
 * @summary 自定义异常
 */
@Data
public class CustomException extends Exception {
    private static final long serialVersionUID = 9076925801616372566L;

    private Integer errorCode;

    private String errorMsg;

    public CustomException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public CustomException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorMsg = message;
        this.errorCode = errorCode;
    }

    public CustomException(RetCodeEnum codeEnum){
        this.errorCode = codeEnum.getCode();
        this.errorMsg = codeEnum.getName();
    }
}