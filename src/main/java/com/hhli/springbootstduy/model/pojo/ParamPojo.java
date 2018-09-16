package com.hhli.springbootstduy.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by hhli_yangyu on 2018/9/16.
 * @author hhli_yangyu
 * @summary rest api测试参数对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamPojo {
    private Long id;

    private String name;
}
