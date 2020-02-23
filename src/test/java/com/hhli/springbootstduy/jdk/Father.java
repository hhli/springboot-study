package com.hhli.springbootstduy.jdk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 李辉辉
 * @date 2019-11-13 20:52
 * @description
 */
@Setter
@Getter
@ToString
public class Father implements Serializable {

    private static final long serialVersionUID = 6825218465868806205L;

    private long id;

    public Father(long id){
        this.id = id;
    }
}
