package com.hhli.springbootstduy.model.enums;

/**
 * 返回的状态码的定义
 * @author zhangdeman001@ke.com
 */
public enum  CodeEnum {

    /**
     * 定义返回的cod信息
     */
    SUCCESS(0, "success"),
    INVALID_TIMESTAMP(1000, "请求时间戳不合法"),
    REQUEST_EXPIRE(1001, "请求已失效"),
    APP_KEY_EMPTY(1002, "身份未识别"),
    UNAUTHORIZED(1003, "身份未授权"),
    API_ACCESS_UNAUTHORIZED(1003, "接口无访问权限"),
    SIGN_ERROR(1004, "无效的签名"),
    TOO_MANY_REQUEST(1005, "请求太频繁"),
    NO_LEAVE_QUOTA(1006, "超过配额"),
    IAM_AUTH_ERROR(1007, "IAM认证失败"),

    OAUTH_SUCCESS(1100, "成功"),
    OAUTH_PARAM_ERROR(1101, "参数错误"),
    OAUTH_INVALID_TOKEN(1102, "错误的token"),
    OAUTH_EXPIRED(1103, "token过期"),
    OAUTH_NOACCESS(1104, "无权限"),
    OAUTH_ERROR(1199, "OAUTH认证失败"),


    PARAM_GROUP_ERROR(2000, "不符合参数请求规则"),
    PARAM_MISS_ERROR(2001, "缺少必要请求参数"),
    PARAM_TYPE_ERROR(2002, "参数类型不正确"),
    PARAM_EMPTY_ERROR(2003, "参数不能为空"),
    PARAM_LIMIT_ERROR(2004, "参数范围不正确"),
    VALIDATE_FUNC_NOT_FOUND(2005, "校验函数不存在"),
    VALIDATE_TYPE_ERROR(2006, "类型校验失败"),
    TIME_FORMAT_ERROR(2007, "时间格式不正确"),
    UNSUPPORT_PARAM_TYPE(2008, "不支持的参数类型"),
    HAS_NO_DATA_PERMISSION(2009, "无可读数据权限"),

    CIRCLE_DATA_FIELD_ERROR(2010, "回流数据字段错误"),
    CIRCLE_DATA_FORMAT_ERROR(2011, "回流数据格式错误"),

    CURL_REQUEST_CONNECT_TIMEOUT(3000, "远程服务连接超时"),
    CURL_REQUEST_TIMEOUT(3001, "远程调用请求超时"),
    CURL_REQUEST_UNKNOWN_ERROR(3002, "远程调用未知格式错误"),
    CURL_REQUEST_ERROR(3003, "远程调用错误"),
    CURL_RESPONSE_PARSE_ERROR(3004, "远程响应数据解析失败"),

    QUERY_DATA_ERROR(4001, "数据查询失败"),


    NO_ROUTE(-1, "http://open.lianjia.com/"),
    NO_SUPPORT_METHOD(-2, "不支持的请求方法"),
    ERROR_REQUEST_HEADER(-3, "请求头信息解析异常"),
    ERROR_SERVICE_INIT(-4, "服务启动初始化中，请稍后重试"),
    ERROR_CONVERT_REQUEST_PARAM(-5,"请求参数转换异常"),
    INTERNAL_SERVICE_ERROR(-6,"请求异常"),
    CURL_RESPONSE_ERROR(-7, "远程调用返回状态错误");

    private Integer code;
    private String message;
    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static CodeEnum parse(Integer code) {
        for (CodeEnum codeEnum : CodeEnum.values()) {
            if (codeEnum.getCode().equals(code)) {
                return codeEnum;
            }
        }
        return null;
    }
}