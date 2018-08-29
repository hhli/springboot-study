package com.hhli.springbootstduy.model.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hhli.springbootstduy.model.enums.RetCodeEnum;
import com.hhli.springbootstduy.model.exception.CustomException;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by hhli_yangyu on 2018/3/22.
 * @author hhli_yangyu
 * @summary 返回值封装
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ResultDataVo implements Serializable{
    private static final long serialVersionUID = 8167231153515927926L;

    public ResultDataVo() {
        super();
    }

    public ResultDataVo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultDataVo(String message) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.message = message;
    }

    /**
     * 返回单个实体
     */
    public <T> ResultDataVo(T entity) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.message = RetCodeEnum.SUCCESS.getName();
        this.data = entity;
    }


    /**
     * 返回集合类型
     */
    public <T> ResultDataVo(List<T> list) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.message = RetCodeEnum.SUCCESS.getName();
        this.data = list == null ? Collections.EMPTY_LIST : list;
    }

    /**
     * 返回Map集合类型
     */
    public ResultDataVo(Map<String, Object> map) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.message = RetCodeEnum.SUCCESS.getName();
        this.data = map;
    }

    /**
     * 返回分页List集合
     */
    public <T> ResultDataVo(List<T> list, Page page) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.message = RetCodeEnum.SUCCESS.getName();
        this.data = list == null ? Collections.EMPTY_LIST : list;
        this.page = page;
    }

    /**
     * 返回分页Map集合类型
     */
    public ResultDataVo(Map<String, Object> map, Page page) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.data = map;
        this.page = page;
    }

    /**
     * 返回分页Object
     */
    public ResultDataVo(Object data, Page page) {
        super();
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.data = data;
        this.page = page;
    }


    public ResultDataVo(CustomException ex) {
        this.code = ex.getErrorCode();
        this.message = ex.getMessage();
    }

    /**
     * 异常,
     */
    public ResultDataVo(Exception ex) {
        this(ex, true);
    }

    /**
     * 异常
     */
    public ResultDataVo(Exception ex, Boolean showStackTrace) {
        this.code = RetCodeEnum.SYSTEM_EXCEPTION.getCode();
        this.message = getErrorMessage(ex);
        if (showStackTrace) {
            ex.printStackTrace();
        }
    }

    /**
     * 运行时异常
     */
    public ResultDataVo(Throwable tx) {
        this.code = RetCodeEnum.SYSTEM_EXCEPTION.getCode();
        this.message = tx.getMessage();
    }

    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 结果数据，单个实体 或 List<T>
     */
    private Object data;

    /**
     * 分页数据
     */
    //如果为null不参与序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Page page;

    private static String getErrorMessage(Exception ex) {
        if (ex instanceof ArithmeticException) {
            return "系统异常：计算错误";
        }
        if (ex instanceof NullPointerException) {
            return "系统异常：输入错误，缺少输入值";
        }
        if (ex instanceof ClassCastException) {
            return "系统异常：类型转换错误";
        }
        if (ex instanceof NegativeArraySizeException) {
            return "系统异常：集合负数";
        }
        if (ex instanceof ArrayIndexOutOfBoundsException) {
            return "系统异常：集合超出范围";
        }
        if (ex instanceof FileNotFoundException) {
            return "系统异常：文件未找到";
        }
        if (ex instanceof NumberFormatException) {
            return "系统异常：输入数字错误";
        }
        if (ex instanceof SQLException) {
            return "系统异常：数据库异常";
        }
        if (ex instanceof IOException) {
            return "系统异常：文件读写错误";
        }
        if (ex instanceof NoSuchMethodException) {
            return "系统异常：方法找不到";
        }
        return ex.getMessage();
    }

    // -------------------------- getter and setter ----------------------------

    public ResultDataVo setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ResultDataVo setData(Object data) {
        this.data = data;
        return this;
    }

    public ResultDataVo setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResultDataVo setFlexiPageDto(Page page) {
        this.page = page;
        return this;
    }

    @Data
    public static class Page {

        String totalPage;
        String pageNum;
        String pageSize;
        String totalCount;

        public Page(String totalPage, String pageNum, String pageSize, String totalCount) {
            this.totalPage = totalPage;
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.totalCount = totalCount;
        }

    }

}