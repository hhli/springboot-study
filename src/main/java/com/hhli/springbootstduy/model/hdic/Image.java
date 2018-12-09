package com.hhli.springbootstduy.model.hdic;

import lombok.Data;

import java.util.List;

/**
 * @author 李辉辉
 * @date 2018/12/4 20:29
 * @description 图片数据
 */
@Data
public class Image {
    private Long id;

    private String url;

    private List<ResblockImage> resblockImageList;

}
