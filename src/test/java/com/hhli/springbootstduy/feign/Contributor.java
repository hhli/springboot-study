package com.hhli.springbootstduy.feign;

import lombok.Data;

/**
 * Created by hhli_yangyu on 2018/8/19.
 * @author hhli_yangyu
 * @summary 贡献人
 */
@Data
public class Contributor {
    /** 用户 **/
    private String login;
    /** 贡献数量 **/
    private int contributions;
}
