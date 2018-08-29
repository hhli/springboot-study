package com.hhli.springbootstduy.model.enums;

/**
 * Created by hhli_yangyu on 2018/3/22.
 * @author hhli_yangyu
 * @summary 返回结果枚举
 */
public enum RetCodeEnum {
    SUCCESS(0, "成功"),

    NOT_LOGIN(10,"未登录"),

    PERMANENTLY_MOVED(301,"永久性转移"),

    ERROR_SERVICE(500,"业务逻辑错误"),

    ERROR_FUNCTION(501,"功能不完善，无对应方法"),

    CODE_ERROR_WEB(502,"网络异常"),

    PARAM_EXCEPTION(1000, "参数异常"),

    PARAM_DUPLICATE_EXCEPTION(1001,"参数已存在"),

    PARAM_NULL_EXCEPTION(1002,"参数为空"),

    PARAM_RANGE_ERROR_EXCEPTION(1003,"参数取值范围错误"),

    PARAM_LIST_NULL_EXCEPTION(1004,"List集合为空"),

    PARAM_NOT_EXIST_EXCEPTION(1005,"参数不存在"),

    PARAM_NOT_ILLEGAL(1006, "参数非法"),

    VALIDATE_EXCEPTION(1006,"校验异常"),

    DB_EXCEPTION(2000, "数据库异常"),

    DATA_NULL(2500, "数据不存在"),

    OBJECT_NULL(2501,"对象为空"),

    AUTH_EXCEPTION(3000, "权限异常"),

    LOCK_EXCEPTION(4000, "锁异常"),

    TRANSACTION_EXCEPTION(5000, "事务异常"),

    RPC_EXCEPTION(6000, "远程接口异常"),

    HOOK_EXCEPTION(7000, "钩子异常"),

    OPERATE_EXCEPTION(8000, "非法操作"),

    PERMISSION_DENIED(9000,"没有权限操作"),

    SYSTEM_EXCEPTION(9999, "其他异常");

    RetCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        for (RetCodeEnum codeEnum : RetCodeEnum.values()) {
            if (codeEnum.getCode().equals(code)) {
                return codeEnum.getName();
            }
        }
        return null;
    }

    public static RetCodeEnum getByCode(Integer code) {
        for (RetCodeEnum codeEnum : RetCodeEnum.values()) {
            if (codeEnum.getCode().equals(code)) {
                return codeEnum;
            }
        }
        return null;
    }
}
