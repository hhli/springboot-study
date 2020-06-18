package com.hhli.springbootstduy.model.enums;

import java.util.Arrays;

public enum ParamEnum {
    /**
     * 公共参数的枚举
     * @author zhangdeman001@ke.com
     */
    SIGN("sign", "签名参数参数字段"),
    APP_KEY("appKey", "接入方身份字段名"),
    TIMESTAMP("ts", "时间戳字段名"),
    DISABLE_CACHE("disableCache", "禁用缓存"),
    AUTH_UID("authUid", "请求人ID"),
    ;
    private String paramName;
    private String message;
    ParamEnum(String paramName, String message) {
        this.paramName = paramName;
        this.message = message;
    }

    public String getParamName() {
        return this.paramName;
    }

    public String getMessage() {
        return this.message;
    }

    public static boolean isParamName(String name) {
        return Arrays.stream(values()).map(ParamEnum::getParamName).anyMatch(e -> e.equals(name));
    }
}