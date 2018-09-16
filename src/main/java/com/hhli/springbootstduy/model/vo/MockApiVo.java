package com.hhli.springbootstduy.model.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by hhli_yangyu on 2018/9/16.
 * @author hhli_yangyu
 * @summary mock api vo
 */
@Data
public class MockApiVo {
    private Long id;

    private LocalDate createdAt;

    private String name;

    private String avatar;
}
