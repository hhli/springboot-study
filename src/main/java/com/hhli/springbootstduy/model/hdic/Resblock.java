package com.hhli.springbootstduy.model.hdic;

import lombok.Data;

import java.util.List;

/**
 * @author 李辉辉
 * @date 2018/12/4 20:26
 * @description 楼盘
 */
@Data
public class Resblock {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 楼栋列表
     */
    List<Building> buildingList;
}
